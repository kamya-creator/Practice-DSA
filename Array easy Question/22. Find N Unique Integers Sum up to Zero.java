class Solution {
    public int[] sumZero(int n) {
        
        
        /*
        Approach is simple , in order to get total sum = 0 , 
        if number of +ve and -ve number gets equal(identical one for             example -1 and 1 or -2 and 2) 
        then sum will be zero for sure 
        */
        
        /*
        so start positive number from 1
        and negative number from 1
        */
        int[] arr = new int[n];
        int positive = 1;
        int negative = 1;
        
        if(n%2 == 0) // when n is even then +ve number = -ve number 
        {
            for(int i =0;i<n/2;i++)
            {
                arr[i] = positive++; // filling first half with positive numbers
                arr[i + n/2] = -(negative++); // filling second half with negative numbers
            }
        }
        else{
            arr[0] = 0;  // when n is even add 0 at index zero and then follow same above approach (i.e for odd n)
            
            
            for(int i =1;i<=n/2;i++)
            {
                arr[i] = positive++;
                arr[i + n/2] = -(negative++);
            }
        }
        return arr;
            
    }
}
