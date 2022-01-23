class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        int n = nums.length;
        for(int i =0;i<n;i++)
        {
            freq[nums[i]]++;
        }
        
        // Calcuate Running Sum for freq array
        for(int i =1;i<freq.length;i++)
        {
            freq[i] = freq[i] + freq[i-1];
        }
        
        // Store result 
        int[] res = new int[n];
        for(int i =0;i<n;i++)
        {
            if(nums[i] != 0)
            {
                res[i] = freq[nums[i] -1];
            }
            else // when nums[i] = 0
                res[i] = 0;
        }
        return res;
    }
}
