class Solution {
    public int search(int[] nums, int target) {
        int indx = BinarySearch(nums, target,0,nums.length-1);
        return indx;
    }
    public int BinarySearch(int[] nums, int key , int start, int end)
    {
        if(start > end)
        {
            return -1;
        }
        
        int mid = start + (end-start)/2;
        if(nums[mid] == key)
        {
            return mid;
        }
        if(nums[mid] > key)
        {
           return  BinarySearch(nums, key, start, mid-1);
        }
        return BinarySearch(nums, key, mid+1, end);
    }
}
