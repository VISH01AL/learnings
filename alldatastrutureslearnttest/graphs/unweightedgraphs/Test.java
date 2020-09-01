package unweightedgraphs;

public class Test {

	public static void main(String[] args) {
		Graph g=new Graph(7);
		g.addEdge(0, 1,true);
		g.addEdge(0, 2,true);
		g.addEdge(1, 3,true);
		g.addEdge(2, 3,true);
		g.addEdge(2, 4,true);
		g.addEdge(4, 5,true);
		g.addEdge(3, 5,true);
		g.addEdge(5, 6,true);
		g.addEdge(3, 6,true);
//		g.printAdjanceyList();
//		g.dfs(0);
//		g.dfs(6);
//		g.bfs(0);
//		g.bfs(6);
		g.shortestpath(0, 6);
		g.shortestpath(4, 3);
		g.shortestpath(1, 4);
		g.shortestpath(1, 5);
		g.shortestpath(1, 6);
		g.shortestpath(2, 6);
		g.shortestpath(4, 6);
	}

}
