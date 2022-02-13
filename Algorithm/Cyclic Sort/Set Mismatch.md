https://leetcode.com/problems/set-mismatch/

```
class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int n = nums.length;
        
        int i =0;
        while(i<n)
        {
            int correct = nums[i] -1;
            if(nums[i]  != nums[correct])
            {
                swap(nums, i, correct);
            }
            else
                i++;
        }
        int[] ans = new int[2];
        for(i =0;i<n;i++)
        {
            if(nums[i] != i+1)
            {
                ans[0] = nums[i];
                ans[1] = i+1;
            }
        }
        return ans;
    }
    public void swap(int[] nums,int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
}
