package MinHeap;



public class Test {

	public static void main(String[] args) {
		PriorityQueue pq=new PriorityQueue(10);
		for(int i=0;i<10;i++)
		{
			pq.insert((int)(Math.random()*100));
		}
		pq.print();
		pq.change();
		System.out.println("delete start");
		for(int i=0;i<10;i++)
		{
			System.out.print(pq.delete()+" ");
		}
		System.out.println();
		System.out.println("delete start");
		
	}

}
