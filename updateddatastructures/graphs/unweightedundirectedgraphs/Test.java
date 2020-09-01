package unweightedundirectedgraphs;


public class Test {
	public static void main(String[] args) {
		Graph g=new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(3, 6);
        g.printlist();
        g.bfs(0);
        g.dfs(0);
       g.shortestpath(0, 6);
		g.shortestpath(4, 3);
		g.shortestpath(1, 4);
		g.shortestpath(1, 5);
		g.shortestpath(1, 6);
		g.shortestpath(2, 6);
		g.shortestpath(4, 6);
	}
}
