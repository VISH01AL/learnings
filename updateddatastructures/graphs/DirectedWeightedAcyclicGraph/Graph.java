package DirectedWeightedAcyclicGraph;
import java.util.*;
public class Graph {
private int V;
private ArrayList<HashMap<Integer,Integer>> vert;
Graph(int v){
	this.V=v;
	this.vert=new ArrayList<HashMap<Integer,Integer>>();
	for(int i=0;i<this.V;i++) {
		this.vert.add(new HashMap<Integer,Integer>());
	}
}
public void addEdge(int u,int v,int wei) {
	this.vert.get(u).put(v,wei);
}
public int[] topologicalsort() {//O(V+E)
	return this.topologicalsort(this.vert,this.V);
}
private int[] topologicalsort(ArrayList<HashMap<Integer,Integer>> g,int v) {
	boolean[] visited=new boolean[v];
	int[] topsort=new int[v];
	int pt=v-1;
	for(int i=0;i<v;i++) {
		pt=dfs(g,i,pt,visited,topsort);
	}
	return topsort;
}
private int dfs(ArrayList<HashMap<Integer,Integer>> g,int src,int i,boolean[] visited,int[] topsort) {
	if(visited[src]) {
		return i;
	}
	visited[src]=true;
	for(HashMap<Integer,Integer> hs:g) {
		for(Map.Entry<Integer,Integer> hm:hs.entrySet()) {
			i=dfs(g,hm.getKey(),i,visited,topsort);
		}
	}
	topsort[i]=src;
	return i-1;
}
public void shortestpathtoallvertices(int src) {//O(V+E)
	this.shortestpath(this.vert,src,this.V,this.topologicalsort());
}
private void shortestpath(ArrayList<HashMap<Integer,Integer>> g,int src,int v,int[] topsort) {
	int[] dist=new int[v];
	Arrays.fill(dist, Integer.MAX_VALUE);
	int s=search(topsort,src);
	dist[src]=0;
	for(int i=s;i<v;i++) {
		HashMap<Integer,Integer> temp=g.get(i);
		for(Map.Entry<Integer,Integer> it:temp.entrySet()) {
			if(it.getValue()+dist[i]<dist[it.getKey()]) {
				dist[it.getKey()]=it.getValue()+dist[i];
			}
		}
	}
	System.out.print("shortest path from all vertices to "+src+":");
	for(int x:dist) {
		if(x==Integer.MAX_VALUE) {
			System.out.print("INF"+" ");
		}
		else {
			System.out.print(x+" ");
		}	
	}
	System.out.println();
}
private int search(int[] arr,int src) {
	for(int i=0;i<arr.length;i++) {
		if(arr[i]==src) {
			return i;
		}
	}
	return -1;
}
public void longestpathtoallvertices(int src) {//O(V+E)
	this.longestpath(this.vert, src, this.V,this.topologicalsort());
}
private void longestpath(ArrayList<HashMap<Integer,Integer>> g,int src,int v,int[] topsort) {
	int[] dist=new int[v];
	Arrays.fill(dist, Integer.MIN_VALUE);
	int s=search(topsort,src);
	dist[src]=0;
	for(int i=s;i<v;i++) {
		HashMap<Integer,Integer> temp=g.get(i);
		for(Map.Entry<Integer,Integer> it:temp.entrySet()) {
			if(dist[it.getKey()]<dist[i]+it.getValue()) {
				dist[it.getKey()]=dist[i]+it.getValue();
			}
		}
	}
	System.out.print("longest path from all vertices to "+src+":");
	for(int x:dist) {
		if(x==Integer.MIN_VALUE) {
			System.out.print("-INF"+" ");
		}
		else {
			System.out.print(x+" ");
		}	
	}
}
}

