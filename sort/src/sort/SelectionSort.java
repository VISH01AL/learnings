package sort;

import java.util.Scanner;

public class SelectionSort {
    public static int min(int []arr,int index)
    {
    	int min=arr[index];
    	int id=index;
    	for(int i=index+1;i<arr.length;i++)
    	{
    		if(arr[i]<min)
    		{
    			min=arr[i];
    			id=i;
    		}
    	}
    	return id;
    }
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of array:");
		n=sc.nextInt();
		int[] arr=new int[n];
		System.out.println("enter the "+n+" array elements:");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		int temp;
		for(int i=0;i<n-1;i++)
		{
			int val=min(arr,i);
			temp=arr[i];
			arr[i]=arr[val];
			arr[val]=temp;		
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]);
		}
		sc.close();

	}

}
