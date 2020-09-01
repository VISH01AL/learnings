package DirectedunWeightedAcyclicGraphs;
import java.util.*;
public class Graph {
private ArrayList<ArrayList<Integer>> vert;
private int V;
Graph(int v){
	this.V=v;
	this.vert=new ArrayList<ArrayList<Integer>>(this.V);
	for(int i=0;i<this.V;i++) {
		this.vert.add(new ArrayList<Integer>());
	}
}
public void addEdge(int u,int v) {
	this.vert.get(u).add(v);
}
public void printlist() {
	this.printlist(this.vert);
}
private void printlist(ArrayList<ArrayList<Integer>> g) {
	int count=0;
	for(ArrayList<Integer> x:g) {
		System.out.print(count+"->");
		for(Integer y:x) {
			System.out.print(y+" ");
		}
		count++;
		System.out.println();
	}
}
public int[] topologicalsort() {
	
	return this.topologicalsort(this.vert,this.V);
}
private int[] topologicalsort(ArrayList<ArrayList<Integer>> g,int v) {//Time Complexity: O(V+E).
	boolean[] visited=new boolean[v];
	int[] topsort=new int[v];
	int pt=v-1;
	for(int i=0;i<v;i++) {
		pt=dfs(g,i,pt,v,visited,topsort);
	}
	return topsort;
}
private int dfs(ArrayList<ArrayList<Integer>> g,int src,int i,int v,boolean[] visited,int[] topsort) {
	if(visited[src]) {
		return i;
	}
	visited[src]=true;
	for(Integer x:g.get(src)) {
		i=dfs(g,x,i,v,visited,topsort);
	}
	topsort[i]=src;
	return i-1;
}
}
