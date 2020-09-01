package MaxHeap;

public class Test {

	public static void main(String[] args) {
		PriorityQueue pq=new PriorityQueue(10);
		for(int i=0;i<10;i++)
		{
			pq.insert((int)(Math.random()*100));
		}
		pq.print();
		for(int i=0;i<10;i++)
		{
			System.out.print(pq.delete()+" ");
		}
	}

}
