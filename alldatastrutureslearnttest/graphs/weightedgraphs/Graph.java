package weightedgraphs;
import java.util.*;
public class Graph {
int V;
ArrayList<ArrayList<Integer>> vert;
Graph(int V){
	this.V=V;
	this.vert=new ArrayList<ArrayList<Integer>>();
	for(int i=0;i<V;i++) {
		this.vert.add(new ArrayList<Integer>());
	}
}
public void addEdge(int u,int w) {
	vert.get(u).add(w);
}
public int[] shortestpathijefficient(int src) {
	return shortestpathefficient(this.vert,src,this.V);
}
private int[] shortestpathefficient(ArrayList<ArrayList<Integer>> vert,int src,int v) {
	boolean[] visited=new boolean[v];
	int[] dist=new int[v];
	PriorityQueue<pair> pq=new PriorityQueue<pair>((pair p1,pair p2)-> {
		return p1.weight.compareTo(p2.weight);
	});
	Arrays.fill(dist, Integer.MAX_VALUE);
	dist[src]=0;
	pq.add(new pair(src,0));
	while(!pq.isEmpty()) {
		pair p=pq.poll();
		int minind=p.ind;
		if (dist[p.ind]<p.weight) {
			continue;
		}
		visited[minind]=true;
		int count=0;
		for(Integer x:vert.get(minind)) {
			if(!visited[count] && x!=0 && dist[minind]+x<dist[count]) {
				dist[count]=dist[minind]+x;
				pq.add(new pair(count,dist[minind]+x));
			}
			count++;
		}
	}
	return dist;
}
public int[] shortestpathdij(int src) {
	return shortestpath(this.vert,src,this.V);
}
private int[] shortestpath(ArrayList<ArrayList<Integer>> ver,int src,int v) {
	int[] dist=new int[v];
	boolean[] visited=new boolean[v];
	Arrays.fill(dist,Integer.MAX_VALUE);
	dist[src]=0;
	for(int i=0;i<v-1;i++) {
		 int minval=Integer.MAX_VALUE;
		 int min=v;
		 for(int j=0;j<v;j++) {
			 if(!visited[j] && dist[j]<minval) {
				 minval=dist[j];
				 min=j;
			 }
		 }
		 visited[min]=true;
		 int count=0;
		 for(Integer x:ver.get(min)) {
			 if(!visited[count] && x!=0 && dist[min]+x<dist[count]) {
				 dist[count]=dist[min]+x;
			 }
			 count++;
		 }
	}
	return dist;
}
public void printlist() {
	printlist(this.vert,this.V);
}
private void printlist(ArrayList<ArrayList<Integer>> ver,int V) {
	for(int i=0;i<V;i++) {
		System.out.print(i+"->");
		for(Integer y:ver.get(i)) {
			System.out.print(y+" ");
		}
		System.out.println();
	}
}
}
class pair{
	int ind;
	Integer weight;
	pair(int ind,int wei){
		this.ind=ind;
		this.weight=wei;
	}
}
