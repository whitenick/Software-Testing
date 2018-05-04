package pset7;

public class AdditionExpression extends IntegerExpression {
	String var1, var2;

	AdditionExpression(String v1, String v2) {
		var1 = v1;
		var2 = v2;
	}

	int evaluate(CandidateSolution candidate) {
		HashMap<String, Integer> map = candidate.candidate;
		Integer returnVal = 0;

		for(String key: map) {
			if(map.get(key).equals(var1) || map.get(key).equals(var2)) {
				returnVal =+ map.get(key);
			}
		}
		return returnVal;
	}
