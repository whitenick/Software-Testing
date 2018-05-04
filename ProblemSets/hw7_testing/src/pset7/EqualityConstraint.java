package pset7;
import java.util.*;
import org.nasa.Verify;

public class EqualityConstraint extends IntegerConstraint {
	IntegerExpression lhs, rhs;

	EqualityConstraint(IntegerExpression lhs, IntegerExpression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	boolean evaluate(CandidateSolution candidate) {
		return lhs.evaluate(candidate) == rhs.evaluate(candidate); 
	}


