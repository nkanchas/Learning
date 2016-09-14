package GraphProblems;

public class Edge {
	
	Vertex vertex;
	int cost = 1;
	
	public Edge(Vertex vertex) {
		this.vertex = vertex;
	}
	
	public Edge(Vertex vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}
	
	public Vertex getVertex() {
		return vertex;
	}
	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
