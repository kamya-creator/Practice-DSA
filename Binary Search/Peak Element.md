
    https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/1720953/JAVA-or
class Solution {
    
    /*
    As Array is sorted in both accending and descending order i.e first ahlf is in increasing order and second half is in descending order
    So we are going to apply Binary Search with slight Modification.
    
    Notice here like BS(Binary Search) we are not given any target value , instead we have to find largest element in array (i.e Peak of Mountain) so we don't require arr[mid] == target condition.
    
    As Array conatin both(assecending and descending) sorted elements, the mid is going to point either at elemet that lie in asscending order part of array or descending order part of array, so our problem is divided into two Cases:
    
    Case 1 : when arr[mid] lie in asscending part of array ( arr[mid] < arr[mid+1]) , then it is sure that there exist elemnt which is greater than arr[mid] so arr[mid] can't be PEAK element , so now search in right part of array , and for this
    start = mid+1;
    
    
    Case 2 : when arr[mid] lie in descending part of array ( arr[mid] > arr[mid+1]) , then it is posiible that arr[mid] could be the PEAK element and it is also possible that there exist elemnt which is greater than arr[mid] so arr[mid] can't be PEAK element , so now search in left  part of array including current mid as it's eligible to be PEAK element , and for this
    end = mid;
    
    
    */
    
    
    
    
    public int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end = arr.length-1;
        int ans = BinarySearchPeakIndex(arr,start,end);
        return ans;
    }
    public int BinarySearchPeakIndex(int[]arr,int start,int end)
    {
        
        while(start < end)
        {
            
        int mid = start + (end- start)/2;
            
           // Implemented Case 2 
        if(mid+1 < arr.length &&  arr[mid] > arr[mid+1]) // Now u r in decreasing part of array 
            
            {
                end = mid;
            }
           // Implemented Case 1
            else if((mid+1 < arr.length) && arr[mid] < arr[mid+1]) // Now u r in increaing part of arry
            {
                start = mid+1;
            }
        }
        return start;
    }
}
