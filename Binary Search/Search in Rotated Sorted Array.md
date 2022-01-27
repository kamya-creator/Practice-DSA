https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/1723692/Java-or-Binary-Search-or-100-Faster
class Solution {
    public int search(int[] nums, int target) {
        
        int PeakIndex = PeakElementIndexBS(nums);
        //System.out.print(PeakIndex);
        if(PeakIndex == -1)
            return  BinarySearch(nums, 0, nums.length -1,target);
        int ans =-1;
        ans = BinarySearch(nums, 0, PeakIndex,target);
        if(ans == -1)
            ans = BinarySearch(nums, PeakIndex+1, nums.length-1,target);
        return ans;
    }
    public int PeakElementIndexBS(int[] arr)
    {
        int start =0;
        int end = arr.length-1;
        
        while(start<= end)
        {
            int mid = start + (end - start)/2;
            
            if(mid+1 <= end && arr[mid] > arr[mid+1])
                return mid;
            else if(mid-1 >= start && arr[mid] < arr[mid-1])
                return mid-1;
            
            else if(arr[start] < arr[mid])
            {
                start = mid+1;
            }
            else 
                end = mid -1;
        }
        return -1;
    }
    public int BinarySearch(int[] arr,int start,int end,int target)
    {
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            
            
            if(arr[mid] > target)
            {
                end = mid-1;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
