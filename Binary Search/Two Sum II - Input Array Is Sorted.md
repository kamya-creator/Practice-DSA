https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/1725840/Javaor-Two-Pointer-approach

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
         ans = TwoPointer(numbers, target,ans);
        return ans;
    }
    
    public int[] TwoPointer(int[] nums , int target,int[] ans)
    {
        int start =0;
        int end = nums.length-1 ;
        while(start < end)
        {
            if(nums[start] + nums[end] < target )
            {
                start++;
            }
            else if(nums[start] + nums[end] > target)
            {
                end--;
            }
            else if(nums[start] + nums[end] == target){
                ans[0] = start+1;
                ans[1] = end+1;
                return ans;
            }
        }
        return ans;
    }
}

