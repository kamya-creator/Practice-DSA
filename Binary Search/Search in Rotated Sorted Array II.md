Same as search in rotated sorted array without duplicates , just little modification required

if(arr[s] == arr[e])
then first check if element at s or element at e are pivot or not,
if they are not pivot then skip them by moving "s" pointer forward and "e" pointer backward

```
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target;
       int PeakIndex = PeakElementIndex(nums); 
        boolean res = false;
        res = BinarySearch(0,PeakIndex,nums,target);
        if(res)
            return true;
            
        else 
            return BinarySearch(PeakIndex+1,nums.length-1,nums,target);
    }
    public boolean BinarySearch(int start, int end , int[] arr, int key)
    {
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            
            if(arr[mid] > key)
                end = mid-1;
            else if(arr[mid] < key)
                start = mid+1;
            else
                return true;
            
        }
        return false;
    }
    public int PeakElementIndex(int[] nums)
    {
        
        int s =0;
        int e = nums.length -1;
        while(s<= e)
        {
            int m = s + (e-s)/2;
            
            if(m +1 < nums.length && nums[m+1] < nums[m])
            
                return m;
            
            else if(m - 1 >=0 && nums[m-1] > nums[m])
            
                return m-1;
            
            else if(nums[s] == nums[e])
            {
                if(s+1 <nums.length && nums[s] > nums[s+1])
                    return s;
                // else if(e-1 >= 0 && nums[e-1] > nums[e])
                //     return e-1;
    
                else{
                    // Skiping the duplicates elements
                    
                    s++;    
                    e--;
                }
            }
            else if(nums[m] >= nums[s])  // Note elemnt at m can be equal to element at s
            {                            // Hence move s to m+1 , as pivot element cannot                                          // lie in increasing part of array
                s= m +1;
            }
            else{
                e = m;
            }
        }
        return -1;
    }
}
