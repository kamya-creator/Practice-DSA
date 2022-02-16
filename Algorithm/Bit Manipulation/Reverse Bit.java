public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        int res =0;   // initialize reverse res as zero (no bit is set)
        int j = 0;    // j pointing to MSB (most significant bit) of res
        
        // Traverse n which is of 32 bit from end and check if ith's ith bit set or not
        for(int i = 31; i>=0 ;i--)
        {   
            // the mask is used to move 1 to left each time when i move to left
            int mask = 1<<i;
            
            // if n & mask results in non - zero number then it means bit is set at ith place hence set the bit in res at jth place also
            if((n & mask) != 0) // & operator is used to check if bit is 1 or 0 i.e set or unset
            {   
                // In order to set bit at jth place we need setmask which would have 1 (set bit) at jth position only
                int smask = 1<<j;
                res = res | smask;  // | (or) operator is used to set bit 
                j++;  // don't forget to move j pointer too, as it is helpful in setting res 
            }
            // if n & mask results in  zero number then it means bit is unset at ith place hence no need to set the bit in res at jth place , just move j to next
            else
                j++;
            
        } return res;
    }
}
