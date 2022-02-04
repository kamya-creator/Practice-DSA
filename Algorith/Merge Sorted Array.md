
https://leetcode.com/problems/merge-sorted-array/discuss/1744314/Java-Solution-with-Comment-or-Approach-Explanation
```



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1; // pointer to fill the largest element in nums1  
        int p1 = m-1; // pointer for nums1 element
        int p2 = n-1;  // pointer for nums2 element
        
        while(p2 >= 0)  // looping till nums2 size because nums2 will always be smaller than nums1 in size
        {
            // finding the larger element from nums1 and nums2 and placing it at it's correct position
            if(p1>=0 && nums1[p1] > nums2[p2]) 
                // if nums1 element is greater than nums2 then replace nums1[i] with greater element and reduce the pointer i and p1 because now i will point to next position where next greater element will be filled 
                nums1[i--] = nums1[p1--];
            else
                
                 // if nums2 element is greater than nums1 then replace nums1[i] with greater element and reduce the pointer i and p2 because now i will point to next position where next greater element will be filled 
                nums1[i--] = nums2[p2--];
        }
    }
}
