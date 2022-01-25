/*
Runtime: 1 ms, faster than 24.78% of Java online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 44.3 MB, less than 9.12% of Java online submissions for Find First and Last Position of Element in Sorted Array.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = FirtstPosition(nums,target);
        int lastOccurence = LastPosition(nums,target);
        int[]  res = new int[2];
        res[0] = firstOccurence;
        res[1] = lastOccurence;
        
        return res;
    }
    
    public int FirtstPosition(int[] nums,int target)
    {
        int start =0;
        int firstOccurence = -1;
        int end = nums.length -1;
        
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target)
            {
                firstOccurence=mid;
                end = mid-1;
            }
            else if(nums[mid] > target)
            {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return firstOccurence;
    }
    
    public int LastPosition(int[] nums,int target)
    {
        int start =0;
        int lastOccurence = -1;
        int end = nums.length -1;
        
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target)
            {
                lastOccurence=mid;
                start = mid+1;
            }
            else if(nums[mid] > target)
            {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return lastOccurence;
    }
}



### Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
### Memory Usage: 44 MB, less than 39.44% of Java online submissions for Find First and Last Position of Element in Sorted Array.
  
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        
        int firstIndx = BinarySearch(nums, target, true);
        int lastIndx = BinarySearch(nums, target, false);
        
        ans[0] = firstIndx;
        ans[1] = lastIndx;
        
        return ans;
    }
    public int BinarySearch(int[] nums, int target, boolean search4FirstOccurance)
    {
        int start = 0;
        int end = nums.length -1;
        int ans =-1; // Desired index will be stored in it
        
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target )
            {   
                ans = mid;
                if(search4FirstOccurance)
                    end = mid -1;
                else
                    start = mid+1;
                    
            }
            else if(nums[mid] > target)
            {
                end = mid-1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
    }
}
