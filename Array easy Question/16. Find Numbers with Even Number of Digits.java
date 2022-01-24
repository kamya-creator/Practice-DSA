class Solution {
    public int findNumbers(int[] nums) {
        
        int res  =0 ;
        for(int ele : nums)
        {
            int ans = countDigit(ele);
            if(ans %2 == 0)
                res++;
        }
        return res;
    }
    public int countDigit(int ele)
    {
        if(ele <0)
        {
            ele = ele *-1;
        }
      // Formula to get number of digits in Decimal Number System..... For more shortcut formula watch Number system tut by Kunal
        return (int)(Math.log10(ele) +1);
    }
}
