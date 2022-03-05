// Thing I learnt here is :
// In order to print any subsequence which sum is K, print at very first when the subsequence satisity the sum condition then return true
// Main thing is that return true when subsequence is found not need to take further recursive calls.
//   So instead of void the function will be of boolean type and return true if subsequence is found else try another function call and return true if subsequence is found 
//   else return false



/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static boolean printSubSequenceSumK(int index , int[] arr, ArrayList<Integer> ds, int s, int sum, int n)
    {
        if(index == n)
        {
            if(s == sum)
            {
                System.out.println(ds);
                return true;
            }
            return false;
        }
        // Take the element
        s = s + arr[index];
        ds.add(arr[index]);
        if(printSubSequenceSumK(index+1, arr, ds, s, sum , n) == true) return true;
        
      // Don't take the element
        s = s - arr[index];
        ds.remove(new Integer(arr[index]));
        if(printSubSequenceSumK(index+1, arr, ds, s, sum, n) == true) return true;
        
        
        return false;
    }
	public static void main (String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int sum = 10;
		int n =arr.length;
		ArrayList<Integer> ds = new ArrayList<>();
		printSubSequenceSumK(0,arr, ds, 0, sum, n);
	}
}


// Time(sec) : 0.1Memory(MB) : 47.6367
// Output:
// [1, 2, 3, 4]
