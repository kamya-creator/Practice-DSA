https://leetcode.com/problems/first-missing-positive/
```
class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        
        if(n == 1 && nums[0] ==1) return 2;
        
        int i =0;
        while(i<n)
        {   
            int correct = nums[i] -1;
            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct])
            {
                swap(nums, i , correct);
            }
            else
                i++;
        }
        //System.out.print(Arrays.toString(nums));
        for( i =0;i< n;i++)
        {
            if( nums[i] != i +1)
                return i+1;
        }
        return n+1;
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
