https://leetcode.com/problems/reverse-string-ii/discuss/1749330/Java-Multiple-Solution

```
class Solution {
    public String reverseStr(String s, int k) {
        
        int n = s.length();
        char[] a = s.toCharArray();
        int i;
        String str = "";
        if(n>=k)
        {       
            for( i =0;i<n;i=i+2*k)
            { 
                swap(a,i,i+k-1);
            }
              
       }  
       else 
       {    swap(a,0,n-1);
            for( i = 0;i<a.length;i++)
            {
                str = str + a[i];
            }

            return str;
        
       }
        
        for( i = 0;i<a.length;i++)
            {
                str = str + a[i];
            }
         
        return str;
    }
    public void swap(char[] a, int start , int end)
    {
        
         
        if(end > a.length)
        {
            end = a.length-1;
        }
        while(start <= end )
        {
            char temp = a[start];
            a[start] = a[end];
            a[end ] = temp;
            
            start++;
            end--;
        }
       
    }
}
