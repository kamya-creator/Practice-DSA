/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	    int[] arr = {1,4,3,-5,-4,8,6};
	    int[] max = new int[1];
	    int[] min = new int[1];
	    solve(arr, max, min, 0);
		System.out.println(max[0] +" "+min[0]);
	}
	public static void solve(int[] arr, int[] max, int[] min , int indx)
	{
	    if(indx == arr.length)
	    return;
	    
	    if(arr[indx] > max[0])
	    {
	        max[0] = arr[indx];
	    }
	    if(arr[indx] < min[0])
	    {
	        min[0] = arr[indx];
	    }
	    
	    solve(arr, max, min, indx+1);
	}
}
