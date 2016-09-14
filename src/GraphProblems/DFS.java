package GraphProblems;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
	
	private Set<Vertex> visited = new HashSet<>();
	private Stack<Vertex> stack = new Stack<>();
	
	
	public void traverse(Vertex vertex) {
		
		visited.add(vertex);
		
		addEdgeVertices(vertex);
		
		while (!stack.isEmpty()) {
			Vertex curr = stack.pop();
			//System.out.println(" "+ curr.getLabel());
			if (!visited.contains(curr)) {
				visited.add(curr);
				addEdgeVertices(curr);
			}
		}
		
	}


	protected void addEdgeVertices(Vertex vertex) {
		for (Edge edge: vertex.edges) {
			stack.push(edge.vertex);
		}
	}


	public Set<Vertex> getVisited() {
		return visited;
	}


	public void setVisited(Set<Vertex> visited) {
		this.visited = visited;
	}
	
	

}
