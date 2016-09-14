package GraphProblems;


public class UnDirectedGraph extends Graph {

	public int oddDegreesOfFreedomCount() {
		
		int oddDegreesOfFreedomCount = 0;

		for (Vertex vertex : vertices) {
			if (vertex.getEdges().size() % 2 == 1) {
				oddDegreesOfFreedomCount++;
			}
		}

		return oddDegreesOfFreedomCount;
	}
	
	public boolean hasEulerianPaths() {
		if (!isConnected())
			return false;
		
		int count = oddDegreesOfFreedomCount();
		
		if (count != 0 && count != 2) {
			return false;
		}
		
		return true;
	}
	
	public boolean hasEulerianCycle() {
		
		if (!isConnected())
			return false;
		
		for (Vertex vertex : vertices) {
			if (vertex.getEdges().size() % 2 == 1) {
				return false;
			}
		}
		
		return true;
	}

	public boolean isEulerian() {
		return hasEulerianPaths();
	}
}
