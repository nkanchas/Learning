package GraphProblems;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
	
	private String label;
	List<Edge> edges = new LinkedList<>();
	
	public Vertex(String name) {
		this.label = name;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	
	
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public void addUnDirectedEdge(Edge edge) {
		addEdge(edge);
		edge.vertex.addEdge(new Edge(this, edge.cost));
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	
}
