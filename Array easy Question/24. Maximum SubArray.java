class Solution {
    public int maxSubArray(int[] nums) {
        
        // Kadane's Algorith is used here
        /*
        we can understand with an example, suppose you want to invest in share market, and you see profit in investing only when if u have worth ammount to invest i.e your current total is positive so u contribute ur money to market share in thought there might be profit in future 
        
        Now comes to scenario Second when ur balace is already in negative so u r not in situation of investing right.
        
        Kadane algo is also work in similar fashion
        Contibute to currSum only when it is positive otherwise currSum = nums[i] 
        */
        int currSum = nums[0];     
        int max = nums[0];
        
        for(int i =1;i< nums.length;i++)
        {
            if(currSum >= 0)
            {
                currSum = currSum + nums[i];
            }
            else
            {
                currSum = nums[i];
            }
            
            if(max < currSum)
                max = currSum;
        }
        return max;
    }
}
