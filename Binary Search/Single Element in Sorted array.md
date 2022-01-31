https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/1733719/java-or-Easy-explanation-or-O(logn)-or-O(1)

Brute Force Approach is easy , we can use XOR oprator and can find single element and TC : O(n)
Let's try some other method
we have sorted array , and we have to find an element in O(logn) TC , Let's try Binary Serach


0 1 | 2 | 3 4 5 6 7 8-------------------index
A A | B | C C D D E E-------------------array
        ⁑
      Single Element
low = 0
high = 8
mid = 4

Observation :
    Index of Pair before single element is in fashion of ## Even Odd   (left half)
    Index of Pair before single element is in fashion of ## Odd Even   (right half)


For Left Half

Hence if mid is even check if it's next element is eqaul to arr[mid] ,
if yes then it means you are in left half of array and need to move to right half.
Why is it so?
because array is sorted already then the pair in left half would follow EVEN ODD index property then it is sure that single element would not lie there hence shrink the left half


For Right Half

Hence if mid is even check if it's previous element is eqaul to arr[mid] ,
if yes then it means you are in right half of array and need to move to left half.
Why is it so?
because array is sorted already then the pair in right half would follow  ODD EVEN index property then it is sure that single element would not lie there hence shrink the right half



At the end we would left with two elements and we just need to check weather they are equal or not

```
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int low = 0;
        int high = nums.length -1;
        
        // Boundary Cases
        if(high == 0)
            return nums[0];
        if(nums[low] != nums[low+1])
            return nums[low];
        else if(nums[high] != nums[high -1])
            return nums[high];
        
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            
            else if(mid % 2== 0 && nums[mid] == nums[mid+1]    // Checking the property of Left Half
                   || mid%2 !=0 && nums[mid] == nums[mid-1])
            {
                low = mid+1;     // Shrink the left half
            }
            else{
                high = mid-1;    // shrink the right half
            }
        }return -1;
    }
}

