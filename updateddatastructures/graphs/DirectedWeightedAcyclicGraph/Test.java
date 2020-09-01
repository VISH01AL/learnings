package DirectedWeightedAcyclicGraph;

public class Test {
	public static void print(int[] arr) {
		for(int x:arr) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Graph g = new Graph(6); 
        g.addEdge(0, 1, 5); 
        g.addEdge(0, 2, 3); 
        g.addEdge(1, 3, 6); 
        g.addEdge(1, 2, 2); 
        g.addEdge(2, 4, 4); 
        g.addEdge(2, 5, 2); 
        g.addEdge(2, 3, 7); 
        //g.addEdge(3, 5, 1);//comment it for longest path for getting same answer as geeksforgeeks
        g.addEdge(3, 4, -1); 
        g.addEdge(4, 5, -2); 
        print(g.topologicalsort());
        g.shortestpathtoallvertices(1);
        g.longestpathtoallvertices(1);
	}

}
