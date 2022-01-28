https://leetcode.com/problems/valid-perfect-square/discuss/1725882/Java-Solution-or-Binary-Search
```
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num ==1)
            return true;
        
        long start =1;
        long end = num/2;
        
        while(start <= end)
        {
            long mid = start + (end - start)/2;
            
            if(mid*mid == num)
                return true;
            
            if(mid > num/mid)
                end = mid-1;
            else  {
                start = mid +1;
            } 
        }
        
        return false;
        
    }
    
}
