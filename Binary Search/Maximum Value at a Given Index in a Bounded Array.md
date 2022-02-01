https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/discuss/1736831/Java-or-Binary-Search-or-Intuition-Explained

/*
What we can try is put maximum Integer value at target index given in question and then fill the left and right part in such a way it satisfy all the given condition
But it would give TLE as interger max value is very high and checking for every integer will given TLE error.

It means TC will be O(n), let's reduce it .

We have given maxSum in question and lowest value nums[i] can have is 1 as nums[i] must be positive , so we have a range for nums[index] between 1 to maxSum
So in order to find the desired nums[index] we would apply Binary Search

Now problem reduces to fill three part of array

----------------------------------------
________________________________________
|Left Part|MAXIMUM ELEMENT | Right part|
|_________|________________|___________|


1.          1<=Maximum Element<maxSum
2.   Left part sum + maximum element + right part sum <= maxSum

Now lo = 1 and high = maxSum
Calculate mid which represents the possible value of maximum element

left part right most element would be mid -1 (as mentioned in question abs(nums[i] - nums[i+1]) <= 1)
right part left most element would be mid -1 (as mentioned in question abs(nums[i] - nums[i+1]) <= 1)

Now calculate left part sum and right part sum

now if total of these sum (i.e left part sum + mid element + right part sum )
is greater than maxSum reduce high pointer to mid-1
otherwise increase low pointer to mid+1

*/


```
class Solution {
    public int maxValue(int n, int index, int maxSum) {
       int l = index; // Number of elements in left part
        int r = n-index-1; // Number of elements in right part
        
        // range for nums[index]
        long lo = 1;   
        long high = maxSum;
        
        long sum =0;
        
        // final answer is stored in res
        long res =0;
        
        
        while(lo <= high)
        {
            long mid = lo + (high-lo)/2;
            long ls =0; // Left Part sum
            long rs = 0; // Right Part Sum
            sum = mid;
            
            long m = mid-1;  // used in finding left sum and right sum
            
            if(r > 0)
            {
                if(r<=m)   
                {   /*
                    When right part is filled with decreasing order natural numbers
                    then use this formula
                    */
                    rs = m*(m+1)/2 - (m-r)*(m-r+1)/2;
                }else
                    /*
                    When right part is filled with 1's then use this formula
                    */
                    rs = m*(m+1)/2 + 1*(r-m);
            }
            if(l>0)
            {
            if(l<=m)
                
                /*
                9+8+7+6 = (1+2+3+4+5+.......+8+9) - (1+2+3+4+5)
                */
                ls = m*(m+1)/2 - (m-l)*(m-l+1)/2;
            else
                     
                ls = m*(m+1)/2 + 1*(l-m);
            }
            // sum = left part + mid element + right part
            sum = sum +ls +rs;
            
            if(sum <= maxSum)
            {   res = Math.max(res,mid);  // Storing the maximum nums[index] 
                //System.out.print(res);
                lo = mid+1;
            }else{
                high = mid-1;
            }
            
            
        }
        
        return (int)res;
        
        
        
    }
}
