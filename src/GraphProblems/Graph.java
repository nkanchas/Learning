package GraphProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Graph {
	
	protected Set<Vertex> vertices = new HashSet<>();	
	
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
	}
	
	
	public boolean isConnected() {
		if (vertices.isEmpty()) return false;
		
		DFS dfs = new DFS();
		dfs.traverse(vertices.iterator().next());
		Set<Vertex> visited = dfs.getVisited();
		
		return vertices.size() == visited.size() ? true : false;  
	}
	
	public Graph getTranspose () {
		Graph transposed = new Graph();
		
		transposed.vertices.addAll(transpose().values());
		
		return transposed;
	}
	
	
	private Map<String, Vertex> transpose() {
		
		final Map<String, Vertex> verticesinTransposed = new HashMap<String, Vertex>();
		
		DFS dfs = new DFS() {
			
			protected void addEdgeVertices(Vertex vertex) {
				
				super.addEdgeVertices(vertex);
				
				Vertex reverseVertex = getVertexInTransposed(verticesinTransposed, vertex.getLabel());
				
				for (Edge edge: vertex.edges) {
					Vertex edgeVertex = getVertexInTransposed(
							verticesinTransposed, edge.vertex.getLabel());
					
					Edge reverseEdge = new Edge(reverseVertex, edge.getCost());
					edgeVertex.addEdge(reverseEdge);
				}
			}

			private Vertex getVertexInTransposed(
					final Map<String, Vertex> verticesinTransposed, String label) {
				Vertex edgeVertex = verticesinTransposed.get(label);
				
				if (edgeVertex == null) {
					edgeVertex = new Vertex(label);
					verticesinTransposed.put(label, edgeVertex);
				}
				return edgeVertex;
			}
		};
		
		dfs.traverse(vertices.iterator().next());
		
		return verticesinTransposed;
		
	}
	
	public boolean hasEulerianCycle() {
		
		if (! isConnected()) return false;
		
		Map<String, Vertex> verticesinTransposed = transpose();
		
		for (Vertex vertex : vertices) {
			Vertex vertexInTransposed = verticesinTransposed.get(vertex.getLabel());
			
			if (vertex.edges.size() != vertexInTransposed.edges.size()) return false;
		}
		
		return true;
	}

}
