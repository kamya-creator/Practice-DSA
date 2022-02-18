/*
First sort the given intervals array in asscending order according to start time i.e column 0 wise 

For output i.e merged intervals final resultant array can be of any size (for sure it must be less than or equal to size og intervals array but still we are uncertain about merged intervals resultant array size ) , so let's take it as List as it's size is dynamically allocated



We will comapre the end time of an interval with the start time of next interval
If start time of an interval is less than the end time of interval previous to it , only then merging is required

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]

current_interval = [1,3]

Add the current_interval in merged_interval list 

merged_interval = [[1,3]]

Now iterate through intervals and check if merging of interval is requird or not




*/

class Solution {
    public int[][] merge(int[][] intervals) {
        // base case if interval array is of size 1 or less than one then no merging is required
        if(intervals.length <=1) return intervals;
        // sorting the given 2D array
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        
        // declaring merged intervals array 
        List<int[]> merged_intervals = new ArrayList<>();
        
        
        int[] current_interval = intervals[0];
        // Note in merged_interval variable is addaed (i.e by refernce)
        merged_intervals.add(current_interval);
        
        for(int[] interval : intervals )
        {
            int current_start = current_interval[0];
            int current_end = current_interval[1];
            
            int next_start = interval[0];
            int next_end = interval[1];
            
            if( next_start <= current_end)
            {   
                // Note that current_interval end time is being updated which will results in updation in merged_interval
                current_interval[1] = Math.max(current_end, next_end);
            }
            else
            {
                current_interval = interval;
                merged_intervals.add(current_interval);
            }
        }
         return merged_intervals.toArray(new int[merged_intervals.size()][]);
        
    }
}
