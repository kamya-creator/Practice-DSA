https://leetcode.com/problems/move-zeroes/discuss/1746205/1ms-or-100-Faster-Java-Solution

```
class Solution {
    public void moveZeroes(int[] nums) {
        
        int nonzero = 0;
        int zero =0;
        
        while(zero< nums.length)
        {
            if(nums[zero] !=0)
            {   swap(nums, zero, nonzero);
                nonzero++;
            }
            zero++;
        }
    }
    public void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        
    }
}
