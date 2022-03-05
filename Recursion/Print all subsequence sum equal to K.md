Refer striver tutorial for same
```
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void printSubSequenceSumK(int index , int[] arr, ArrayList<Integer> ds, int s, int sum, int n)
    {
        if(index == n)
        {
            if(s == sum)
            {
                System.out.println(ds);
            }
            return;
        }
        
        s = s + arr[index];
        ds.add(arr[index]);
        printSubSequenceSumK(index+1, arr, ds, s, sum , n);
        
        s = s - arr[index];
        ds.remove(new Integer(arr[index]));
        printSubSequenceSumK(index+1, arr, ds, s, sum, n);
    }
	public static void main (String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int sum = 10;
		int n =arr.length;
		ArrayList<Integer> ds = new ArrayList<>();
		printSubSequenceSumK(0,arr, ds, 0, sum, n);
	}
}

```
```
Time(sec) : 0.09Memory(MB) : 47.8828
Output:
[1, 2, 3, 4]
[1, 3, 6]
[1, 4, 5]
[2, 3, 5]
[4, 6]
