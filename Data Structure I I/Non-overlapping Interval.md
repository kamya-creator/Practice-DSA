class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 1) return 0;
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] -arr2[0]);
        int count =0;
        
        int prev_start = intervals[0][0];
        int prev_end = intervals[0][1];
        
        for(int i =1 ; i<intervals.length;i++)
        {
            int next_start = intervals[i][0];
            int next_end = intervals[i][1];
            
            if(next_start < prev_end)
            {
                count++;
                prev_end = Math.min(prev_end, next_end);
            }
            else
            {
                prev_start = next_start;
                prev_end = next_end;
            }
        }
        return count;
    }
}
