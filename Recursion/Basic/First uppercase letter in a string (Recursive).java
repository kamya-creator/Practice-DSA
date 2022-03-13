/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	    String str = "geeksFor";
	    solve(str, 0);
		System.out.println("GfG!");
	}
	public static void solve(String str, int indx)
	{
	    if(indx == str.length())
	    return ;
	    
	    if(str.charAt(indx) >='A' && str.charAt(indx) <= 'Z')
	    {   
	        System.out.println(indx);
	        return ;
	    }
	    solve(str, indx+1);
	    return ;
	}
}
