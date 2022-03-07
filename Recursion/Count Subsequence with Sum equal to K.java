/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    public static int CountSubSequenceSum(int idx , int[] arr, int s, int sum, int n)
    {
        if(idx == n)
        {
            if(s == sum)
            return 1;
            
            else return 0;
        }
        
        
        s = s + arr[idx];
        
        int l = CountSubSequenceSum(idx+1, arr, s, sum, n);
        
        s = s - arr[idx];
        int r = CountSubSequenceSum(idx+1 , arr, s, sum ,n);
        
        return l+r;
        
    }
	public static void main (String[] args) {
	    int[] arr = {1,2,3,4,5};
	    int n = arr.length;
	    int sum =10;
	    int s =0;
	    System.out.println(CountSubSequenceSum(0,arr,s ,sum, n) );
		//System.out.println("GfG!");
	}
}
