package sort;

public class MergeSort {

	private static int[] mergeSort(int[] arr)
	{
		if(arr.length<=1)
		{
			return arr;
		}
		int mid=arr.length/2;
		int[] left=new int[mid];
		int[] right;
		if(arr.length%2==0)
		{
			right=new int[mid];
		}
		else {
			right=new int[mid+1];
		}
		for(int i=0;i<left.length;i++)
		{
			left[i]=arr[i];
		}
		for(int i=0;i<right.length;i++)
		{
			right[i]=arr[i+mid];
		}
		
		left=mergeSort(left);
		right=mergeSort(right);
		int[] result=new int[left.length+right.length];
		result=merge(left,right);
		return result;
	}
	private static int[] merge(int[] left,int[] right)
	{
		int[] result=new int[left.length+right.length];
		int leftpointer,rightpointer,resultpointer;
		leftpointer=rightpointer=resultpointer=0;
		while(leftpointer<left.length || rightpointer<right.length)
		{
			if(leftpointer<left.length && rightpointer<right.length)
			{
				if(left[leftpointer]<right[rightpointer])
				{
					result[resultpointer++]=left[leftpointer++];
				}
				else {
					result[resultpointer++]=right[rightpointer++];
				}
			}
			else if(leftpointer<left.length)
			{
				result[resultpointer++]=left[leftpointer++];
			}
			else {
				result[resultpointer++]=right[rightpointer++];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] a= {1,3,5,623,6,32,56,23,5621,652,2,1,76,6,12,56,75,125,823};
		int[] b=mergeSort(a);
		for(int i=0;i<b.length;i++)
		{
			System.out.print(b[i]+" ");
		}
	}

}
