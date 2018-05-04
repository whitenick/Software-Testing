package pset7;

import gov.nasa.jpf.jvm.Verify;
import java.util.HashSet;
import java.util.Set;

public class IntegerConstraintSolver {
	static void solve(IntegerConstraint ic, Set<String> vars) {

		CandidateSolution newCandidate = new CandidateSolution();
		for(String var: vars) {
			newCandidate.set(var, Verify.getInt(0,2));
		}
		boolean result = ic.evaluate(newCandidate);
		if(result) {
			newCandidate.toString();
		}


	}

	public static void main(String[] a) {
		AdditionExpression lhs = new AdditionExpression("x","y");
		EqualityConstraint constraint = new EqualityConstraint(lhs, new AdditionExpression("u","v"));
		Set<String> vars;
		vars.add("u");
		vars.add("v");
		vars.add("x");
		vars.add("y");
		solve(constraint, vars);
	}

}
