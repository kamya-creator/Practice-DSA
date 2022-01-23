class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int[] item : accounts)
        {
            int sum =0;
            for(int ele : item)
                sum+=ele;
            max = Math.max(sum,max);
        } 
        return max;
    }
}
