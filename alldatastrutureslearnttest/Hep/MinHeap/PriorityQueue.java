package MinHeap;

public class PriorityQueue {
private int[] heap;
private int size;
private int n;
PriorityQueue(int n)
{
	this.n=n;
	heap=new int[n];
}
void insert(int data)
{
	insert(data,this.heap,this.size,this.n);
}
private void insert(int data,int[] heap,int size,int n)
{
	if(size<n)
	{
		heap[size]=data;
		this.size++;
	}
}
void change()
{
	change(this.heap,this.size,this.n);
}
private void change(int[] heap,int size,int n)
{
	for(int i=(size-2)/2;i>=0;i--)
	{
		
		heapify(heap,i,size);
	}
}
int delete()
{
	return delete(this.heap,this.size);
}
private int delete(int[] heap,int size)
{
	if(size>0)
	{
		
		int temp=heap[0];
		heap[0]=heap[size-1];
		heap[size-1]=0;
		this.size--;
		
		heapify(heap,0,size-1);
	
		
		return temp;
	}
	return -1;
}
private void heapify(int[] heap,int i,int size)
{
	if(i<size)
	{
	int smallest=i;
	int leftchild=2*i+1;
	int rightchild=2*i+2;
	if(leftchild<size && heap[leftchild]<heap[smallest])
	{
		smallest=leftchild;
	}
	if(rightchild<size && heap[rightchild]<heap[smallest])
	{
		smallest=rightchild;
	}
	if(i!=smallest)
	{
		int temp=heap[i];
		heap[i]=heap[smallest];
		heap[smallest]=temp;
		heapify(heap,smallest,size);
	}
	}
}
void print()
{
	print(this.heap);
}
private void print(int[] heap)
{
	for(int x:heap)
	{
		System.out.print(x+" ");
	}
	System.out.println();
}
}
