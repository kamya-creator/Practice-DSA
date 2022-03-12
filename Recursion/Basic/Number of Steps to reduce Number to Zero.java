class Solution {
    public int numberOfSteps(int num) {
        int count =0;
        int res = solve(num, count);
        return res;
    }
    public int solve(int num, int count)
    {
        if(num == 0)
        {
            return count;
        }
        if(num%2 == 0)
        {   
            count++;
            return solve(num/2, count);
        }
        else
        {
            count++;
            return solve(num-1,count);
        }
    }
}
