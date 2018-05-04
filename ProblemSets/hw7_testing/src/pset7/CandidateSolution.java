package pset7;

import java.util.*;

public class CandidateSolution {
	Map<String, Integer> candidate = new HashMap<String, Integer>();

	void set(String var, int value) {
		candidate.put(var, value);
	}

	int value(String var) {
		// postcondition: returns the value of var in the map
		if(candidate.get(var) == null) {
			throw new RuntimeException("unknown variable: " + var);
		}
		return candidate.get(var);
	}

	public String toString() {
		return candidate.toString();
	}
}

