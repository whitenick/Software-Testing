package pset3;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;
import java.util.*;

public class GraphGenerator {
	int exitPosition = -1;

	public CFG createCFG(String className) throws ClassNotFoundException {
		CFG cfg = new CFG();
		JavaClass jc = Repository.lookupClass(className);
		ClassGen cg = new ClassGen(jc);
		ConstantPoolGen cpg = cg.getConstantPool();

		for(Method m: cg.getMethods()) {
			MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
			InstructionList instruct = mg.getInstructionList();
			InstructionHandle[] handles = instruct.getInstructionHandles();
			InstructionHandle prevHandle = null;
			for (InstructionHandle ih: handles) {
				int position = ih.getPosition();
				cfg.addNode(position, m, jc);
				Instruction inst = ih.getInstruction();
				if (inst instanceof BranchInstruction) {
					InstructionHandle split = ((BranchInstruction)inst).getTarget();
					cfg.addEdge(position, split.getPosition(), m, jc);
				} else if (inst instanceof ReturnInstruction) {
					cfg.addEdge(position, exitPosition, m, jc);
				}

				if(prevHandle != null) {
					if(!(prevHandle.getInstruction() instanceof ReturnInstruction)) {
						cfg.addEdge(prevHandle.getPosition(), position, m, jc);
					}
				}

				prevHandle = ih;
			}
		}
		return cfg;
	}

	public CFG createCFGWithMethodInvocation(String className) throws ClassNotFoundException {
		CFG cfg = new CFG();
		JavaClass jc = Repository.lookupClass(className);
		ClassGen cg = new ClassGen(jc);
		ConstantPoolGen cpg = cg.getConstantPool();
		Method[] methods = cg.getMethods();

		ArrayList<CFG.Group<CFG.Node, String>> invokedMethods = new ArrayList<CFG.Group<CFG.Node, String>>();
		ArrayList<CFG.Group<String, CFG.Node>> returnedMethods = new ArrayList<CFG.Group<String, CFG.Node>>();
		HashMap<String, CFG.Node> endMethod = new HashMap<String, CFG.Node>();
		HashMap<String, CFG.Node> startMethod = new HashMap<String, CFG.Node>();
		for(Method m: methods) {
			MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
			InstructionList instruct = mg.getInstructionList();
			InstructionHandle[] handles = instruct.getInstructionHandles();
			InstructionHandle prevHandle = null;
			String methodName = m.getName() + m.getSignature();

			for(InstructionHandle ih: handles) {
				int position = ih.getPosition();
				cfg.addNode(position, m, jc);
				Instruction inst = ih.getInstruction();

				if(position == 0) {
					CFG.Node startNode = new CFG.Node(position, m, jc);
					startMethod.put(methodName, startNode);
				}
				if(inst instanceof BranchInstruction) {
					BranchInstruction branch = (BranchInstruction) inst;
					InstructionHandle split = branch.getTarget();
					cfg.addEdge(position, split.getPosition(), m, jc);
				} else if(inst instanceof ReturnInstruction) {
					cfg.addEdge(position, exitPosition, m, jc);
				}

				if(prevHandle != null) {
					if(prevHandle.getInstruction() instanceof INVOKESTATIC) {
						INVOKESTATIC methodInvoke = (INVOKESTATIC)prevHandle.getInstruction();
						String called = methodInvoke.getMethodName(cpg) + methodInvoke.getSignature(cpg);
						CFG.Group<CFG.Node, String> tempAdd = new CFG.Group<CFG.Node, String>(new CFG.Node(prevHandle.getPosition(), m, jc), called);
						invokedMethods.add(tempAdd);
						CFG.Group<String, CFG.Node> tempReturn = new CFG.Group<String, CFG.Node>(called, new CFG.Node(prevHandle.getNext().getPosition(), m, jc));
						returnedMethods.add(tempReturn);
					} else if(!(prevHandle.getInstruction() instanceof ReturnInstruction)) {
						cfg.addEdge(prevHandle.getPosition(), position, m, jc);
					}
				}
				prevHandle = ih;
			}
			CFG.Node endNode = new CFG.Node(exitPosition, m, jc);
			endMethod.put(methodName, endNode);
		}

		for(CFG.Group<CFG.Node, String> set: invokedMethods) {
			CFG.Node begin = set.left();
			CFG.Node end = startMethod.get(set.right());
			cfg.addEdge(begin.position, begin.method, begin.clazz, end.position, end.method, end.clazz);
		}
		for(CFG.Group<String, CFG.Node> set: returnedMethods) {
			CFG.Node begin = endMethod.get(set.left());
			CFG.Node end = set.right();
			cfg.addEdge(begin.position, begin.method, begin.clazz, end.position, end.method, end.clazz);
		}
		return cfg;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		GraphGenerator gg = new GraphGenerator();
		gg.createCFG("pset3.C"); // example invocation of createCFG
		gg.createCFGWithMethodInvocation("pset3.D"); // example invocation of createCFGWithMethodInovcation
	}
}
