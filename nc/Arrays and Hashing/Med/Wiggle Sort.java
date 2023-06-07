import java.util.* ;
import java.io.*; 
public class Solution {
	public static int[] wiggleSort(int n, int[] arr) {

		for(int i=0;i<n-1;i++)
		{
			if((i%2==0 && arr[i]>arr[i+1]) || (i%2==1 && arr[i]<arr[i+1]))
			{
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		return arr;
	}
}
