package sort;

public class QuickSort {
	public static int[] quickSort(int[] arr,int st,int end)
	{
		if(st<end)
		{
			int q=partition(arr,st,end);
			quickSort(arr,st,q-1);
			quickSort(arr,q+1,end);
		}
		return arr;
	}
	public static int partition(int[] arr,int st,int end) {
		int x=arr[end];
		int i=st-1;
		int temp;
		for(int j=st;j<end;j++)
		{
			if(arr[j]<x)
			{
				i++;
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		temp=arr[i+1];
		arr[i+1]=arr[end];
		arr[end]=temp;
		return i+1;
	}
	public static void printArray(int[] arr)
	{
		for(int x1:arr)
		{
			System.out.print(x1+" ");
		}
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,43,1,4,5,6};
		printArray(quickSort(arr,0,arr.length-1));

	}

}
