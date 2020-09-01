package weightedundirectedgraphs;
import java.util.*;

public class Graph {
private ArrayList<HashMap<Integer,Integer>> vert;
private int V;
Graph(int v){
	this.V=v;
	this.vert=new ArrayList<HashMap<Integer,Integer>>();
	for(int i=0;i<v;i++) {
		this.vert.add(new HashMap<Integer,Integer>());
	}
}
public void addEdge(int u,int v,int wei) {
	this.vert.get(u).put(v,wei);
	this.vert.get(v).put(u,wei);
}
public void printlist() {
	this.printlist(this.vert,this.V);
}
private void printlist(ArrayList<HashMap<Integer,Integer>> g,int v) {
	int count=0;
	for(HashMap<Integer,Integer> hm:g) {
		System.out.print(count+"->");
		for(Map.Entry<Integer,Integer> x:hm.entrySet()) {
			System.out.print(x.getValue()+" ");
		}
		System.out.println();
		count++;
	}
}
public void shortestpathtoall(int src) {
	this.shortestpathtoall(this.vert,src,this.V);
}
private void shortestpathtoall(ArrayList<HashMap<Integer,Integer>> g,int src,int v) {//Time Complexity:O(E+V)*O(LogV) Dijkrista //can be decreased to O(E + VLogV) using Fibonacci heap
	int[] dist=new int[v];
	Arrays.fill(dist, Integer.MAX_VALUE);
	dist[src]=0;
	boolean[] visited=new boolean[v];
	PriorityQueue<pair> pq=new PriorityQueue<pair>((o1,o2)-> {
		return o1.wei.compareTo(o2.wei);
	});
	pq.add(new pair(src,0));
	while(!pq.isEmpty()) {
		int curr=pq.poll().ver;
		visited[curr]=true;
		HashMap<Integer,Integer> temp=g.get(curr);
		for(Map.Entry<Integer,Integer> it:temp.entrySet()) {
			if(!visited[it.getKey()] && it.getKey()!=curr && dist[curr]+it.getValue()<dist[it.getKey()]) {
				dist[it.getKey()]=dist[curr]+it.getValue();
				pq.add(new pair(it.getKey(),it.getValue()+dist[curr]));
			}
		}
	}
	
	System.out.print("shortest path from all vertices to "+src+":");
	for(int x:dist) {
		System.out.print(x+" ");
	}
	System.out.println();
}
public void minimumspanningtree(int src) {
	this.primminimumspanningtree(this.vert,src,this.V);
}
private void primminimumspanningtree(ArrayList<HashMap<Integer,Integer>> g,int src,int v) {//Time Complexity:O(E+V)*O(LogV)
	int[] wei=new int[v];
	int[] par=new int[v];
	Arrays.fill(wei, Integer.MAX_VALUE);
	wei[src]=0;
	boolean[] visited=new boolean[v];
	PriorityQueue<pair> pq=new PriorityQueue<pair>((o1,o2)-> {
		return o1.wei.compareTo(o2.wei);
	});
	pq.add(new pair(src,0));
	while(!pq.isEmpty()) {
		int curr=pq.poll().ver;
		visited[curr]=true;
		HashMap<Integer,Integer> temp=g.get(curr);
		for(Map.Entry<Integer,Integer> it:temp.entrySet())
		{
			if(!visited[it.getKey()] && it.getValue()<wei[it.getKey()]) {
				par[it.getKey()]=curr;
				wei[it.getKey()]=it.getValue();
				pq.add(new pair(it.getKey(),it.getValue()));
			}
		}
	}
	System.out.println("Edge   Weight");
	int sum=0;
	for(int i=0;i<v;i++) {
		sum+=wei[i];
		System.out.println(par[i]+"-"+i+"    "+wei[i]);
	}
	System.out.print("total weight:"+sum);
}
public void allsourceshortestpath() {
	this.floydwarshall(this.vert,this.V);
}
private void floydwarshall(ArrayList<HashMap<Integer,Integer>> g,int v) {
	int[][] dist=new int[v][v];
	for(int[] x:dist) {
		Arrays.fill(x, 10000000);
	}
	for(int i=0;i<v;i++) {
		for(int j=0;j<v;j++) {
			if(g.get(i).containsKey(j)) {
				if(i!=j) {
					dist[i][j]=g.get(i).get(j);
				}
			}
			if(i==j) {
				dist[i][j]=0;
			}
		}
	}
	for(int k=0;k<v;k++) {
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				if(dist[i][k]+dist[k][j]<dist[i][j]) {
					dist[i][j]=dist[i][k]+dist[k][j];
				}
			}
		}
	}
	this.print(dist);
}
private void print(int[][] arr) {
	for(int[] x:arr) {
		for(int y:x) {
			if(y==Integer.MAX_VALUE) {
				System.out.print("INF ");
			}
			else {
				System.out.print(y+" ");
			}
		}
		System.out.println();
	}
}

public int tsp(int src) {
	int[][] dp=new int[this.V][(1<<this.V)-1];
	for(int[] x:dp) {
		Arrays.fill(x, -1);
	}
	return this.tsp(this.vert,src,src,1<<src,this.V,dp);
}
private int tsp(ArrayList<HashMap<Integer,Integer>> g,int src,int i,int mask,int v,int[][] dp) {//Time Complexity:O((N^2)*(2^N))
	if(mask==(1<<v)-1) {
		return g.get(i).get(src);
	}
	if(dp[i][mask]!=-1) {
		return dp[i][mask];
	}
	HashMap<Integer,Integer> hm=g.get(i);
	int ans=10000000;
	for(Map.Entry<Integer,Integer> x:hm.entrySet()) {
		if( ( (1<<x.getKey()) & mask)==0) {
			ans=Math.min(ans, x.getValue()+this.tsp(g,src,x.getKey(),mask|(1<<x.getKey()),v,dp) );
		}
	}
	return dp[i][mask]=ans;
}

}
class pair{
	int ver;
	Integer wei;
	pair(int ver,int wei) {
		this.ver=ver;
		this.wei=wei;
	}
}
