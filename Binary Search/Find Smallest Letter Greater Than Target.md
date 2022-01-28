```
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        
        /*
        Problem is similar to finding Ceiling of target number with some  modifications.
        Modification 1 . Ceiling is defined as character which is greater than target element
        
        Modification 2 . When there exits no ceiling means all elements of array are smaller than target element then 
        return array element at 0th index
        */
        char res = BinarySearch(letters, target);
        return res;
    }
    public char BinarySearch(char[] letters, char target)
    {
        int start =0;
        int end = letters.length -1;
        
        while(start <= end)
        {
            // calculating mid with this method to 
            // avoid overflow of Integer error
            int mid = start + (end- start)/2; 
            
            
            //Modification 1 : Notice like in usual 
            //Binary serach we first check the target element 
            //with mid element , but we are not doing it here 
            
            if(letters[mid] > target)
                end = mid -1;
            
            if(letters[mid] <= target)
            {
                start = mid+1;
            }
        }
        
        // When breaking condition of while loop
        // hit(i.e start > end)   start will point to Ceiling
        //i.e Smallest Letter Greater Than Target 
        /*
        Reason is because As we were reducing our 
        serching space according to target value in sorted array, 
        so when while loop gets break then start will point 
        to smallest letter Greated than Target
        */
        
        
        
        /*
        When there exits no ceiling means all elements    
        of array are smaller than target element 
        then start will point to 
        out of array , 
        hence according to Modification 2 : return letter[0]
        
        */
        if(start != letters.length)  // Modification 2 is impelemented here
            return letters[start];
        else
            return letters[0];
        
    }
}
