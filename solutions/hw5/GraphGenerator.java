package pset4;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kaiyuan_Wang on 4/15/16.
 */
public class GraphGenerator {
    int testDummyPos = 1000;
    public CFG createCFG(String className) throws ClassNotFoundException {
        CFG cfg = new CFG();
        JavaClass jc = Repository.lookupClass(className);
        ClassGen cg = new ClassGen(jc);
        ConstantPoolGen cpg = cg.getConstantPool();

        for (Method m : cg.getMethods()) {
            MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] handles = il.getInstructionHandles();
            InstructionHandle pre = null;
            for (InstructionHandle ih : handles) {
                int position = ih.getPosition();
                cfg.addNode(position, m, jc);
                Instruction inst = ih.getInstruction();
                // Code goes here
                if (pre != null) {
                    if (!(pre.getInstruction() instanceof ReturnInstruction)) {
                        cfg.addEdge(pre.getPosition(), position, m, jc);
                    }
                }
                if (inst instanceof BranchInstruction) {
                    BranchInstruction bi = (BranchInstruction) inst;
                    InstructionHandle target = bi.getTarget();
                    cfg.addEdge(position, target.getPosition(), m, jc);
                } else if (inst instanceof ReturnInstruction) {
                    cfg.addEdge(position, testDummyPos, m, jc);
                }
                pre = ih;
            }
        }
        return cfg;
    }

    public CFG createCFGWithMethodInvocation(String className) throws ClassNotFoundException {
        CFG cfg = new CFG();
        JavaClass jc = Repository.lookupClass(className);
        ClassGen cg = new ClassGen(jc);
        ConstantPoolGen cpg = cg.getConstantPool();

        // Store the initial instruction for method with a given signature
        Map<String, CFG.Node> m2start = new HashMap<String, CFG.Node>();
        // Store the end (dummy) instruction for method with a given signature
        Map<String, CFG.Node> m2end = new HashMap<String, CFG.Node>();

        // Store the pending addEdge mapping from invokespecial Node to callee signature
        List<Pair<CFG.Node, String>> pendingInvoke = new ArrayList<Pair<CFG.Node, String>>();
        // Store the pending addEdge mapping from callee signature to the next instruction of invokespecial
        List<Pair<String, CFG.Node>> pendingReturn = new ArrayList<Pair<String, CFG.Node>>();

        for (Method m : cg.getMethods()) {
            String methodSignature = m.getName() + m.getSignature();
            MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] handles = il.getInstructionHandles();
            InstructionHandle pre = null;
            for (InstructionHandle ih : handles) {
                int position = ih.getPosition();
                // record initial instruction of each method
                if (position == 0)
                    m2start.put(methodSignature, new CFG.Node(position, m, jc));
                cfg.addNode(position, m, jc);
                Instruction inst = ih.getInstruction();
                // Code goes here
                if (pre != null) {
                    if (pre.getInstruction() instanceof INVOKESTATIC) {
                        INVOKESTATIC is = (INVOKESTATIC) pre.getInstruction();
                        String calleeSignature = is.getMethodName(cpg) + is.getSignature(cpg);
                        pendingInvoke.add(new Pair<CFG.Node, String>(new CFG.Node(pre.getPosition(), m, jc), calleeSignature));
                        pendingReturn.add(new Pair<String, CFG.Node>(calleeSignature, new CFG.Node(pre.getNext().getPosition(), m, jc)));
                    } else if (!(pre.getInstruction() instanceof ReturnInstruction)) {
                        cfg.addEdge(pre.getPosition(), position, m, jc);
                    }
                }
                if (inst instanceof BranchInstruction) {
                    BranchInstruction bi = (BranchInstruction) inst;
                    InstructionHandle target = bi.getTarget();
                    cfg.addEdge(position, target.getPosition(), m, jc);
                } else if (inst instanceof ReturnInstruction) {
                    cfg.addEdge(position, testDummyPos, m, jc);
                }
                pre = ih;
            }
            // record exit (dummy) instruction of each method
            m2end.put(methodSignature, new CFG.Node(testDummyPos, m, jc));
        }

        // Adding invocation edges from caller to callee
        for (Pair<CFG.Node, String> pair : pendingInvoke) {
            CFG.Node from = pair.first();
            CFG.Node to = m2start.get(pair.second());
            cfg.addEdge(from.position, from.method, from.clazz, to.position, to.method, to.clazz);
        }

        // Adding return edges from callee to caller
        for (Pair<String, CFG.Node> pair : pendingReturn) {
            CFG.Node from = m2end.get(pair.first());
            CFG.Node to = pair.second();
            cfg.addEdge(from.position, from.method, from.clazz, to.position, to.method, to.clazz);
        }
        return cfg;
    }
}
