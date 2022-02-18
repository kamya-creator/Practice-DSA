
/*
https://leetcode.com/problems/3sum/discuss/1777785/Java-Solution-with-Approach-Explained
3Sum problem is same as two sum with slight modification
1. nums[i] + nums[j] + nums[k] = 0
    nums[j] + nums[i] = -nums[i]; // Now ques reduced to two sum where target sum is -nums[i]
    
2. Start traversing from i =0 and j i.e low will start from i+1 and k i.e high will start from last index of array
Perform 2Sum approach and take care of duplicte elements 
nums after sorting
nums = [ -4, -1, -1 , 0, 1 ,2]
          i  low           high
          
     nums[low] + nums[high] = -1 + 2 = 1 < -nums[i]  1<4 , so increase the low pointer
 
 nums = [ -4, -1, -1 , 0, 1 ,2]
          i       low       high

nums[low] + nums[high] = -1 + 2 = 1 < -nums[i]  1<4 , so increase the low pointer



 nums = [ -4, -1, -1 , 0, 1 ,2]
          i           low    high

nums[low] + nums[high] = 0 + 2 = 2 < -nums[i]  1<4 , so increase the low pointer



 nums = [ -4, -1, -1 , 0, 1     ,2]
          i              low    high

nums[low] + nums[high] = 1 + 2 = 3 < -nums[i]  1<4 , so increase the low pointer


 nums = [ -4, -1, -1 , 0, 1 ,2]
          i                 high
                            low
Now low == high break the loop and increase the i

nums = [ -4, -1, -1 , 0, 1 ,2]
              i  low      high
                

nums[low] + nums[high] = -1 + 2 = 1 == -nums[i]  1 == 1,  we got a triplet
store then in temp list and add temp list to result list

temp = [-1, -1, 2]     res = [[-1,-1,2]]

When we get the triplet , increase the low and decrease high respectively until when no duplicates are found out


nums = [ -4, -1, -1 , 0, 1 ,2]
              i      low   high
 
 nums[low] + nums[high] = 0 + 2 = 2 > -nums[i]  2 > 1, so increase the low
 
 nums = [ -4, -1, -1 , 0, 1     ,2]
              i          low   high
              
nums[low] + nums[high] = 1 + 2 = 3 >= -nums[i]  3> 1, so decrease the high


nums = [ -4, -1, -1 , 0, 1     ,2]
              i          low   
                        high
break the loop 

Simpliary when for i = 2 the loop run then another triplet i.e [-1,0,1] will be addaed
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i =0;i<n-2;i++)
        {
            if(i == 0 || (i> 0 && nums[i] != nums[i-1]))
            {
                int sum = -nums[i];
                int low = i + 1;
                int high = n-1;
                
                while(low < high)
                {
                    if((nums[low] + nums[high]) == sum)
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        
                        res.add(temp);
                        
                        low++;
                        high--;
                        
                        while(low < high && nums[low] == nums[low-1]) low++;
                        while(high > low && nums[high] == nums[high+1]) high--;
                    }
                    else if((nums[low] + nums[high]) > sum)
                    {
                        high--;
                    }
                    else if((nums[low] +nums[high]) < sum)
                    {
                        low++;
                    }
                }
            }
        } return res;
    }
}
