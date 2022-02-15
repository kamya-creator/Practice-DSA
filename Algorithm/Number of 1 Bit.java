/*
  n  =  0 1 0 1 1
 mask=  0 0 0 0 1
n & mask 0 0 0 0 1   n& mask != 0 so count++ means 1 is found out 
      
left shift the mask by 1       
  n  =  0 1 0 1 1
 mask=  0 0 0 1 0
n & mask 0 0 0 1 0   n& mask != 0 so count++ means 1 is found out 
      
      
     
left shift the mask by 1       
  n  =  0 1 0 1 1
 mask=  0 0 1 0 0
n & mask 0 0 0 0 0     
      
     
left shift the mask by 1       
  n  =  0 1 0 1 1
 mask=  0 1 0 0 0
n & mask 0 1 0 0 0     n& mask != 0 so count++ means 1 is found out 
     
      
left shift the mask by 1       
  n  =  0 1 0 1 1
 mask=  1 0 0 0 0
n & mask 0 0 0 0 0      
     
*/      
      
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int count  = 0;
        int mask =1;
        for(int i =0;i<32;i++)
        {
            if((n & mask) != 0)
                count++;
            
            mask = mask << 1;
        }
        return count;
    }
}
