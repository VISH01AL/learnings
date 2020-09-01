package unweightedundirectedgraphs;
import java.util.*;
public class Graph {
private ArrayList<ArrayList<Integer>> vert;
private int V;
Graph(int v){
	this.vert=new ArrayList<ArrayList<Integer>>();
	for(int i=0;i<v;i++) {
		this.vert.add(new ArrayList<Integer>());
	}
	this.V=v;
}
public void addEdge(int u,int v) {
	this.vert.get(u).add(v);
	this.vert.get(v).add(u);
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

public void bfs(int src) {
	this.bfs(this.vert,src,this.V);
}
private void bfs(ArrayList<ArrayList<Integer>> g,int src,int v) {//Time complexity O(v+E)
	Queue<Integer> q=new LinkedList<Integer>();
	q.add(src);
	
	boolean[] visited=new boolean[v];
	visited[src]=true;
	while(!q.isEmpty()) {
		int curr=q.poll();
		System.out.print(curr+" ");
		for(Integer x:g.get(curr)) {
			if(!visited[x]) {
				q.add(x);
				visited[x]=true;
			}
		}
	}
	System.out.println();
}

public void dfs(int src) {
	boolean[] visited=new boolean[this.V];
	
	this.dfs(this.vert,src,this.V,visited);
	System.out.println();
}
private void dfs(ArrayList<ArrayList<Integer>> g,int src, int V,boolean[] visited) {//Time complexity O(v+E)
	visited[src]=true;
	System.out.print(src+" ");
	for(Integer x:g.get(src)) {
		if(!visited[x]) {
			dfs(g,x,this.V,visited);
		}
	}
}
public void shortestpath(int src,int dest) {
	this.shortestpath(this.vert,src, dest,this.V);
}
private void shortestpath(ArrayList<ArrayList<Integer>> g,int src,int dest,int v) {//Time complexity O(v+E)
	Queue<Integer> q=new LinkedList<Integer>();
	q.add(src);
	boolean[] visited=new boolean[v];
	visited[src]=true;
	int[] parent=new int[v];
	parent[src]=-1;
	outerloop:
	while(!q.isEmpty()) {
		int temp=q.poll();
		for(Integer x:g.get(temp)) {
			if(!visited[x]) {
				visited[x]=true;
				parent[x]=temp;
				q.add(x);
				if(x==dest) {
					break outerloop;
				}
				
			}
		}
	}
	int temp=dest;
	while(temp!=-1) {
		System.out.print("=>"+temp);
		temp=parent[temp];
	}
	System.out.println();
}

}
