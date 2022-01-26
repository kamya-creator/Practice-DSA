https://leetcode.com/problems/find-in-mountain-array/discuss/1721401/Java-or-Order-Agnostic-Binary-Search-or-Peak-element

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int PeakElementIndex = searchPeakElementBS(mountainArr);
        if( mountainArr.get(PeakElementIndex) == target)
        {
            return PeakElementIndex;
        }
        
        // Find in ascending part of array
        int ans = -1;
        ans = OrderAgnosticBinarySearch(mountainArr, 0, PeakElementIndex,target);
        if(ans == -1)
         {
            ans = OrderAgnosticBinarySearch(mountainArr, PeakElementIndex+1, mountainArr.length()-1,target);
            return ans;
         }
        return ans;
        
        
             //return PeakElementIndex;
    }
    
    public int searchPeakElementBS(MountainArray mountainArr)
    {
        int start =0;
        int end = mountainArr.length()-1;
        
        while(start < end)
        {
            int mid = start + (end- start)/2;
            
            
            if( mountainArr.get(mid) < mountainArr.get(mid+1) ) // Asscending part of array
            {
                start = mid+1;
            }
            else   // Descending Part of Array
                end = mid;
        }
        
        return start ;// or return end
    }
    
    public int OrderAgnosticBinarySearch(MountainArray mountainArr, int start, int end, int target)
    {   
        boolean isAscending = mountainArr.get(start) < mountainArr.get(end); 
        
        int mid =-1;
        while(start <= end)
        {
            mid = start + (end-start)/2;
            if(mountainArr.get(mid) == target)
            {
                return mid;
            }
            if(isAscending)
            {    
                if(mountainArr.get(mid) > target)
                {
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                
                if(mountainArr.get(mid) > target)
                {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
