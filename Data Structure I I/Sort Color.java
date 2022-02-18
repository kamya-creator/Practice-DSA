/*
As mentioned in Hint 1 of problem of using counting sort , so I used this method first
Approach : Count the number of zeros , ones and twos in array while traversing it.
Then traverse again and fill the  array with number of zeros, ones and twos .

Code for Approach 1 :

int zero_count =0;
        int one_count =0;
        int two_count = 0;
        
        for(int i =0;i<n;i++)
        {
            if(nums[i] == 0)
                zero_count++;
            
            else if(nums[i] == 1)
                one_count++;
            else
                two_count++;
        }
        
        int idx =0;
        
        while(zero_count-- > 0)
        {
            nums[idx++] =0;
        }
        
        while(one_count-- > 0)
        {
            nums[idx++] =1;
        }
        
        while(two_count-- > 0)
        {
            nums[idx++] =2;
        }
        
TC = O(2N) as we are travesing array two times, we can reduce it to O(N) with the 2nd approach


Approach 2 : Just a premises is followed , If we somehow able to move all zeros to the left hand side of arrray and all twos in right ahnd side of array then , automatically all ones will be in between and array will be sorted

so now ques reduced to move all zeros to left and all twos to right

We are going to maintain two pointers start and end which will keep the track of place where next 0 will come and where next 2 will come respectively
And an index pointer which will help in traversing array and placing current elemt in it's correct place
start = 0;
end = nums.length -1
index = 0
nums = [2,    0,  2,  1,  1,   0]
        start                 end
        index
nums[index] = 2 and two belongs to right part of sorted array , so swap nums[index] with nums[end] and end--;
WHY end--?
Because what we have encounter till now is only nums[index] , and it's sure that what is going at nums[end] is 2 (i.e nums[index]) but we are uncertain about what came at nums[index] after swapping , hence we will decrease the end pointer only as end is pointing to next place where 2 must come

nums = [0,    0,  2,  1,  1,   2]
        start             end
        index

nums[index] = 0 and zero belongs to left part of sorted array ,so swap nums[index] with nums[start] and start++ and index++;

Why start++ and index++ ?
Because now start will point to next place where zero must come and index is checking for further elements


nums = [0,    0,  2,  1,  1,   2]
            start         end
            index

nums[index] = 0 and zero belongs to left part of sorted array ,so swap nums[index] with nums[start] and start++ and index++;

nums = [0,    0,  2,  1,  1,   2]
                start     end
                index
                
nums[index] = 2 and two belongs to right part of sorted array , so swap nums[index] with nums[end] and end--;                
 
nums = [0,    0,  1,  1,  2,   2]
                start  end
                index 
                
Now nums[index] = 1 which means nothing will go to start or end as 1 belongs to in betwwen left and right part of array so just increment index (index++)               

nums = [0,    0,  1,  1,  2,   2]
                start  end
                      index 
                
Now nums[index] = 1 which means nothing will go to start or end as 1 belongs to in betwwen left and right part of array so just increment index (index++)               


nums = [0,    0,  1,  1,  2,   2]
                start  end
                             index 
                
Now index has reached beyound end pointer which signifies that left and right part of array has been filled with correct elements so job is done :)              
*/
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start = 0;
        int index =0;
        int end = n -1;
        
        while(start < end && index <= end)
        {
            if(nums[index] == 0)
            {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
           }
            else if(nums[index] == 2)
            {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }
            else
            {
                index++;
            }
        }
        
    }
}
