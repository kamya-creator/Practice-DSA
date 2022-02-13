https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
```
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        
        int i =0;
        while(i < n)
        {   int correctIndx = nums[i] -1;
            if( nums[i] != nums[correctIndx])
            {
                swap(nums,i, correctIndx);
            }
            else
                i++;
        } 
        
        //System.out.print(Arrays.toString(nums));
        List<Integer> ans = new ArrayList<>();
        for(i=0;i<n;i++)
        {   
            if(nums[i] != i+1)
                ans.add(i+1);
            
        }
        return ans;
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
