package GraphProblems;

public class TestGraph {
	
	public static void main (String [] args) {
		
		/*Vertex f = new Vertex("for");
		Vertex g = new Vertex("geek");
		Vertex r = new Vertex("rig");
		//Vertex k = new Vertex("kaf");
		
		f.addEdge(new Edge(r));
		//g.addEdge(new Edge(k));
		r.addEdge(new Edge(g));
		//k.addEdge(new Edge(f));
		
		Graph graph = new Graph();
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(r);
		//graph.addVertex(k);
*/		
		
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		
		
		zero.addUnDirectedEdge(new Edge(one));
		zero.addUnDirectedEdge(new Edge(two));
		zero.addUnDirectedEdge(new Edge(three));
		//zero.addUnDirectedEdge(new Edge(four));
		
		one.addUnDirectedEdge(new Edge(two));
		
		//one.addUnDirectedEdge(new Edge(three));
		
		three.addUnDirectedEdge(new Edge(four));
		
		UnDirectedGraph graph = new UnDirectedGraph();
		graph.addVertex(zero);
		graph.addVertex(one);
		graph.addVertex(two);
		graph.addVertex(three);
		graph.addVertex(four);
		
		new DFS().traverse(zero);
		//System.out.println("Connected " + graph.isConnected());
		//System.out.println("Has Eulerian Cycle " + graph.hasEulerianCycle());
		//System.out.println("HasEulerian Paths " +graph.hasEulerianPaths());
		
	}

}
