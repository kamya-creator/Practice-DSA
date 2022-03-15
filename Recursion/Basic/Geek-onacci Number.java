/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int i =0;i<t;i++)
		{
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		int N = scn.nextInt();
		int res =0;
		solve(a,b,c, 3, N);
		}
	}
	public static void solve(int a, int b, int c, int count,  int N)
	{
	    if(count == N)
	    {
	        System.out.println(c);
	        return;
	    }
	    solve(b,c, a+b+c,count+1,N); 
	}
}
