Cyclic sort is important topic asked in Amazon and Google


https://leetcode.com/problems/missing-number/

```

class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int i =0;
        while(i<n)
        {
            int correct = nums[i];
            if(nums[i] < n && i != correct)
            {
                swap(nums, i, correct);
                //System.out.print(Arrays.toString(nums));
            }
            else
                i++;
        }
        
        for( i =0;i<n;i++)
        {   //System.out.println(n+ "---------");
            if(nums[i] != i)
                return i;
        }
        //System.out.println(n+ "---------");
        return n;
    }
    
    public void swap(int[] nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
