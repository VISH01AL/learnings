package weightedgraphs;

public class Test {
public static void print(int[] arr,int src) {
	int count=0;
	for(int x:arr) {
		System.out.println("distance from "+src+" to "+count+" is "+x+" ");
		count++;
	}
}
public static void main(String[] args) {
	int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
       Graph g=new Graph(9);
       for(int i=0;i<9;i++) {
    	   for(int j=0;j<9;j++) {
    		   g.addEdge(i, graph[i][j]);
    	   }
       }
       g.printlist();
       System.out.println();
       int src=0;
       int[] arr=g.shortestpathdij(src);
       print(arr,src);
       System.out.println();
       int[] arr2=g.shortestpathijefficient(src);
       print(arr2,src);
}
}

