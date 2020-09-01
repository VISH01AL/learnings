package weightedundirectedgraphs;

public class Test {

	public static void main(String[] args) {
		Graph g= new Graph(9); 
	    g.addEdge(0, 1, 4); 
	    g.addEdge( 0, 7, 8); 
	    g.addEdge( 1, 2, 8); 
	    g.addEdge( 1, 7, 11); 
	    g.addEdge( 2, 3, 7); 
	    g.addEdge(2, 8, 2); 
	    g.addEdge( 2, 5, 4); 
	    g.addEdge( 3, 4, 9); 
	    g.addEdge( 3, 5, 14); 
	    g.addEdge( 4, 5, 10); 
	    g.addEdge( 5, 6, 2); 
	    g.addEdge( 6, 7, 1); 
	    g.addEdge( 6, 8, 6); 
	    g.addEdge( 7, 8, 7); 
	    for(int i=0;i<9;i++) {
	    	g.shortestpathtoall(i);
	    }
	    System.out.println();
	    g.allsourceshortestpath();
	    System.out.println();
	  g.minimumspanningtree(0);
	  Graph g2=new Graph(4);
	  g2.addEdge(0, 1, 10);
	  g2.addEdge(0, 3, 20);
	  g2.addEdge(0, 2, 15);
	  g2.addEdge(1, 2, 35);
	  g2.addEdge(1, 3, 25);
	  g2.addEdge(2, 3, 30);
	  System.out.println();
	 g2.printlist();
	 System.out.println(g2.tsp(0));
	 System.out.println(g2.tsp(1));
	 System.out.println(g2.tsp(2));
	 System.out.println(g2.tsp(3));
	}

}
