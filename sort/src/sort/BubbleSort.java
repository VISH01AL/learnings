package sort;

import java.util.Scanner;

public class BubbleSort {
 public static void main(String args[]) {
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
		for(int j=1;j<n;j++)
		{
		int temp;
		for(int i=0;i<n-j;i++)
		{
			if(arr[i]>arr[i+1])
			{
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]);
		}
		sc.close();
 }

}
