https://leetcode.com/problems/arranging-coins/discuss/1726334/Java-or-Binary-Search-or

```
class Solution {
    public int arrangeCoins(int n) {
        
        int ans = BinarySearch(n);
        return ans;
    }
    public int BinarySearch(int n)
    {
        long start =1;
        long end = n;
        
        while(start <= end)
        {
            long mid = start + (end-start)/2;
            
            // Sum of natural Number
            long sum = mid*(mid+1)/2;
            
            
            if(sum > n)
                end = mid-1;
            
            else if(sum<n){
                start = mid+1;
            }
            else{
                return (int)mid;
            }
        }
        return (int)end;
    }
}
