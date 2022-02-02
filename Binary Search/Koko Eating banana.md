https://leetcode.com/problems/koko-eating-bananas/discuss/1738653/Why-Binary-Search-or-Intiution-explained-or-JAVA


/*
Notice one thing , h (hours of returning of guard) will always be >= length of array.
Why is it so?
Because if h is less than length of array (i.e number of piles) than all banana of every piles can't be eaten. Hence h must be >= arr.length.

Now if the h == arr.length , then minimum banana eating speed must be max element of array.
Why is it so?
Let's understand it with an example --------
piles[] = [2,4,8,12,6]  h = 5

here the minimum banana eating speed must be 12 because only with that speed all piles can be finised within h hours


Now case comes when h is greater than piles.length

Notice , minimum banana eating speed is 1 banana per hour and maximum banana eating speed is Max Element of pile's banana per hour

So we can observe that banana eating speed lies in range of 1 to Max Element of piles
HENCE WE CAN APPLY BINARY SERACH ON banana eating speed

now we have start =1 and end = MAX ELELEMNT 
we'll calculate mid and that will be our potential banana eating speed

CASE 1:
if with mid as our banana eating speed , all piles can be finised within h hours , then store this mid ans our answer and reduce end to mid -1 , as we will check with further low mid values (because we have to find minimum speed possible)



CASE 2:
if with mid as our banana eating speed , all piles can't be finised within h hours , then increase start to mid+1, as we have to increase our banana eating speed in order to finish the piles





*/

```



class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max =0;
        for(int banana : piles)
        {
            max = Math.max(max,banana);
        }
        if(h == piles.length)
            return max;
        
        int bananaEatingSpeed = BinarySearch(piles, 1 , max, h);
        return bananaEatingSpeed;
    }
    public int BinarySearch(int[] arr, int s, int e, int maxHours)     
    {
        int speed = Integer.MAX_VALUE;
        
        
        while(s<=e)
        {
          
            int m = s + (e-s)/2;  
            long timeTaken =0; 
            
            /*
            Calculating the total time taken in finishing the piles with banana eating speed as 'm'
            */
            for(int i : arr)
            {   
                if(m !=0)
                {
                timeTaken = timeTaken + (int)Math.ceil(i*1.0/m);  // we have to take ceil because of this statement-- If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour. 
                }    
            }
            
            
            if(timeTaken > maxHours)
            {
                s = m+1;
            }
            else //if(timeTaken <= maxHours)
            {   if(m > 0)
                {speed = Math.min(speed, m);}       // Storing the minimum banana eating speed
                e = m-1;
            }
        }
        return speed;
        
    }
}
