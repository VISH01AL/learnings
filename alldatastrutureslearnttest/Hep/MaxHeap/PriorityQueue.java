package MaxHeap;

public class PriorityQueue {
private int[] heap;
private int n;
private int size=0;
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
		insertheap(heap,size);
		this.size++;
	}
}
private void insertheap(int[] heap,int i)
{
	int parent=(i-1)/2;
	if(parent>=0)
	{
	if(heap[i]>heap[parent])
	{
		int temp=heap[i];
		heap[i]=heap[parent];
		heap[parent]=temp;
		insertheap(heap,parent);
	}
	}
}
int delete()
{
	return delete(this.heap,this.size,this.n);
}
private int delete(int[] heap,int size,int n)
{
	if(size>0)
	{
		int ret=heap[0];
		heap[0]=heap[size-1];
		heap[size-1]=0;
		this.size--;
		heapify(heap,0,size);
		return ret;
	}
	return -1;
}

private void heapify(int[] heap,int i,int size)
{
	if(i<size)
	{
	int largest=i;
	int leftchild=2*i+1;
	int rightchild=2*i+2;
	if(leftchild<size && heap[leftchild]>heap[largest])
	{
		largest=leftchild;
	}
	if(rightchild<size && heap[rightchild]>heap[largest])
	{
		largest=rightchild;
	}
	if(i!=largest)
	{
		int temp=heap[largest];
		heap[largest]=heap[i];
		heap[i]=temp;
		heapify(heap,largest,size);
	}
	}
}
void print()
{
	print(this.heap);
}
private void print(int[] arr)
{
	for(int x:arr)
	{
		System.out.print(x+" ");
	}
	System.out.println();
}
}
