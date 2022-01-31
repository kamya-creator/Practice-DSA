https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/1733873/0ms-or-Java-or-Binary-Search

### Minimum Element will always lie at pivot index +1 , so we just have to find pivot Index
```
class Solution {
    public int findMin(int[] nums) {
        
        int indexOfPivot = PivotIndex(nums);
        //System.out.print(indexOfPivot);
        if(indexOfPivot != -1)
            return nums[indexOfPivot+1];
        else 
            // when index of Pivot = -1,it signifies the array is sorted hence return nums[0]
            return nums[0];
    }
    
    // Incase if array is already sorted this function gives -1 in output 
    
    public int PivotIndex(int[] nums)
    {
        int s =0;
        int e = nums.length -1;
        
        while(s <= e)
        {
            int m = s+(e-s)/2;
            
            if(m+1 < nums.length &&  nums[m] > nums[m+1])
                return m;
            
            if(m-1 >=0 && nums[m] < nums[m-1])
                return m-1;
            
            if(nums[m] >= nums[s])
                s = m +1;
            else
                e = m;
        }
        return -1;
    }
}
