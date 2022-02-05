https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1746399/Java-Easy-Solution

```
/*
Keep track of minimum prices from left and calculate the profit with minimum price on left .
Update overall profit only when the profit is greater than current profit
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        int minimum = Integer.MAX_VALUE;
        int profit = 0;
        int n = prices.length;
        for(int i =0;i<n;i++)
        {
            if(prices[i] < minimum)
            {
                minimum = prices[i];  // KEeping track of smallestest elemet in left till now
            }
            profit = Math.max(profit, prices[i] - minimum);
//         System.out.println(minimum);
            
//         System.out.print(profit);
        }
        return profit;
    }
}
