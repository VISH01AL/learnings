package unweightedgraphs;
import java.util.*;
public class Graph {
private ArrayList<ArrayList<Integer>> al;
private int V;
Graph(int V)
{
this.V=V;
al=new ArrayList<ArrayList<Integer>>();
for(int i=0;i<V;i++)
{
	al.add(new ArrayList<Integer>());
}
}
void addEdge(int a,int b,boolean bidir)
{
	addEdge(this.al,a,b,bidir);
}
private void addEdge(ArrayList<ArrayList<Integer>> al,int a,int b,boolean bidir)
{
	al.get(a).add(b);
	if(bidir)
	{
	al.get(b).add(a);
	}
}
void printAdjanceyList()
{
	printAdjanceyList(this.al);
}
private void printAdjanceyList(ArrayList<ArrayList<Integer>> al)
{
	Iterator<ArrayList<Integer>> i=al.iterator();
	int count=0;
	while(i.hasNext())
	{
		ArrayList<Integer> temp=i.next();
		System.out.print(count);
		Iterator<Integer> j=temp.iterator();
		while(j.hasNext())
		{
			System.out.print("-->"+j.next());
		}
		count++;
		System.out.println();
	}
}
void bfs(int src)
{
	boolean[] visited=new boolean[this.V];
	bfs(this.al,src,visited);
	System.out.println();
}

private void bfs(ArrayList<ArrayList<Integer>> al,int src,boolean[] visited)
{
	Queue<Integer> q=new LinkedList<Integer>();
	q.add(src);
	System.out.print(src+" ");
	visited[src]=true;
	while(!q.isEmpty())
	{
		ArrayList<Integer> temp=al.get(q.remove());
		int size=temp.size();
		for(int i=0;i<size;i++)
		{
			if(!visited[temp.get(i)])
			{
				System.out.print(temp.get(i)+" ");
				visited[temp.get(i)]=true;
				q.add(temp.get(i));
			}
		}
	}
	
}
void dfs(int src)
{
	boolean[] visited=new boolean[this.V];
	dfs(this.al,src,visited);
	System.out.println();
}
private void dfs(ArrayList<ArrayList<Integer>> al,int src,boolean[] visited)
{
	visited[src]=true;
	System.out.print(src+" ");
	ArrayList<Integer> temp=al.get(src);
	Iterator<Integer> i=temp.iterator();
	while(i.hasNext())
	{
		int tempi=i.next();
		if(!visited[tempi])
		{
			dfs(al,tempi,visited);
		}
	}
}
void shortestpath(int src,int dest)
{
	boolean[] visited=new boolean[this.V];
	int[] dist=new int[this.V];
	int[] parent=new int[this.V];
	shortpath(this.al,src,visited,dist,dest,parent);
	System.out.println();
}
private void shortpath(ArrayList<ArrayList<Integer>> al,int src,boolean[] visited,int[] dist,int dest,int[] par)
{
	Queue<Integer> q=new LinkedList<Integer>();
	q.add(src);
	visited[src]=true;
	par[src]=-1;
	outerloop:
	while(!q.isEmpty())
	{
		int parent=q.remove();
		ArrayList<Integer> temp=al.get(parent);
		int size=temp.size();
		for(int i=0;i<size;i++)
		{
			int tempi=temp.get(i);
			if(!visited[tempi])
			{
				dist[tempi]=dist[parent]+1;
				par[tempi]=parent;
				visited[tempi]=true;
				q.add(tempi);
			}
			if(tempi==dest)
			{
				break outerloop;
			}
		}
		
	}
	System.out.print(dist[dest]);
	System.out.println();
	int t=dest;
	System.out.print(dest);
	while(par[t]!=-1)
	{
		System.out.print("<="+par[t]);
		t=par[t];
	}
}

}
