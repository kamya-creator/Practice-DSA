```
class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int l =0;
        int r = nums.length -1;
        int k = r;
        int[] ans = new int[r+1];
        
        while(l<=r)
        {
            if(Math.abs(nums[l]) > Math.abs(nums[r]))
            {
                ans[k--] = nums[l]*nums[l];
                l++;
            }else{
                ans[k--] = nums[r]*nums[r];
                r--;
            }
        }
        return ans;
        
    }
}
