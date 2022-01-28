https://leetcode.com/problems/sqrtx/discuss/1725673/Java-or-Why-Binary-Search-or-Explanation

```
class Solution {
    
    /*
    Why Binary Search ?
    
    As we know realtion between x and x*x increase monotonically(i.e always increasing in nature) so the intution is as follows.
    
    The square root of number would lie between 0<= (Square Root)< x (where x is number itself) so we can apply BS where start =0 and end =0
    calculate mid and if(mid*mid == x) then mid is ans and if(mid*mid < x) then it is sure that all number's square before mid would be
    smaller than x , Hence we would search in right hand side of mid i.e start = mid+1.
    Notice , But mid could be posible ans too ( For Example condider x = 8) so store mid in ans variable
    
    In case when mid*mid > x then we would search in left hand side of mid by doing this : end = mid-1;
    
    */
    public int mySqrt(int x) {
        if(x == 0 )
            return 0;
        if(x == 1 )
            return 1;
        int ans = BinarySearch(x);
        return ans;
    }
    public int BinarySearch(int x)
    {
        long start = 0;
        long end = x;
        long ans =0;
        
        while(start <= end)
        {
            long mid = start +(end-start)/2;
            
            if(mid == x/mid)
            {
                return (int)mid;
            }
            else if(mid < x/mid)
            {
                ans = mid;
                start =mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return (int)ans;
        
    }
}
