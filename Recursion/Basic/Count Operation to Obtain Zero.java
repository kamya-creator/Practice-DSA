class Solution {
    public int countOperations(int num1, int num2) {
        int count =0;
        if(num1 == 0 || num2 == 0) return 0;
        if(num1== num2)
            return 1;
        int res = solve(num1, num2, count);
        return res;
    }
    public int solve(int num1, int num2, int count)
    {
        if(num1 == 0 || num2 == 0)
        {
            return count;
        }
        if(num1>=num2)
        {
            count++;
            return solve(num1-num2, num2, count);
        }
        else
        {
            count++;
            return solve(num1, num2-num1, count);
        }
    }
}
