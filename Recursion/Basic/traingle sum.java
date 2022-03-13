/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	    int[] arr = {1,2,3,4,5};
	    int n = arr.length;
	    sum(arr, n);
		System.out.println("GfG!");
	}
	public static void sum(int[] arr, int n)
	{   
	    if(n < 1)
	    return;
	    
	    int[] temp = new int[n-1];
	    for(int i =0;i<n-1;i++)
	    {
	        temp[i] = arr[i] + arr[i+1];
	    }
	    
	    sum(temp, n-1);
	    
	    for(int i =0;i<temp.length;i++)
	    {
	        System.out.print(temp[i] + " ");
	    }
	    System.out.println();
	}
}
