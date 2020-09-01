package DirectedunWeightedAcyclicGraphs;

public class Test {
	public static void print(int[] x) {
		for(int y:x) {
			System.out.print(y+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Graph g = new Graph(6);  
        g.addEdge(5, 2);  
        g.addEdge(5, 0);  
        g.addEdge(4, 0);  
        g.addEdge(4, 1);  
        g.addEdge(2, 3);  
        g.addEdge(3, 1);
        g.printlist();
        print(g.topologicalsort());
	}

}
