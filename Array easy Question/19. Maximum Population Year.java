class Solution {
    public int maximumPopulation(int[][] logs) {
        
        
        /*
        Constraints:

        1 <= logs.length <= 100
        1950 <= birthi < deathi <= 2050
        
        */
        /* According to constraint birth and
        death can lie between 1950 and 2050 ,
        so let's maintain array of size 2051, which represent 
        year 
        */
        int[] arr = new int[2051];
        
        // Line Sweep Algorithm
        /*
        for birth year ,increment arr[ele[0]]
        for death year, decrement arr[ele[1]]
        
        We are doing it beacuse , 
        every birth year adds in overall population 
        and death decrease the overall population
        */
        for(int[] ele : logs)
        {
            arr[ele[0]]++;
            arr[ele[1]]--;
        }
        // Calculate Prefix sum;
        /*
        ------------------------------------------------------
        1                  1            2             0
        Now calculate the prefix sum or running 
        sum because it will represent the total 
        population between aech and every year and 
        it will help in finding maximum population year
        
        */
        for(int i = 1950;i<2051;i++)
        {
            arr[i] = arr[i] + arr[i-1];
        }
        
        /*
        Now in arr every element(which represents year) 
        have count of population at that year, 
        we only need to traverse it and find the maximum population 
        and its index represent the respective year
        */
        int maxPop = 0;
        int maxYear = 1950;
        
        for(int i =1950;i<2051;i++)
        {
            if(maxPop < arr[i])
            {    maxPop = arr[i];
                 maxYear = i;
                 
            }
        }
        return maxYear;
        
    }
}
