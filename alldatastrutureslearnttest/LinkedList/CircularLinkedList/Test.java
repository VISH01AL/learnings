package CircularLinkedList;

public class Test {

	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		for(int i=0;i<10;i++)
		{
			ll.insert(i);
		}
		ll.print();
		System.out.println(ll.search(5));
		System.out.println(ll.search(11));
		ll.print();
		System.out.println("delete 9");
		ll.delete(9);
		ll.print();
		System.out.println("delete 1");
		ll.delete(1);
		ll.print();
		System.out.println("delete 0");
		ll.delete(0);
		ll.print();
		ll.delete(2);
		ll.delete(3);
		ll.delete(4);
		ll.delete(5);
		ll.delete(6);
		ll.delete(7);
		System.out.println("delete except one");
		ll.print();
		ll.delete(8);
		System.out.println("delete everything");
		ll.print();
	}

}
