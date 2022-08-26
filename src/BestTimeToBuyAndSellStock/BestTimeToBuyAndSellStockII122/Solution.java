package BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockII122;

/**
 * You are given an integer array prices where prices[i]
 * is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock.
 * You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int dp_0_0 = 0;
        int dp_0_1 = Integer.MIN_VALUE;
        for(int i = 1;i<= prices.length;i++){
            int tmp0 = dp_0_0;
            int tmp1 = dp_0_1;
            dp_0_0 = Math.max(tmp0,tmp1 + prices[i-1]);
            dp_0_1 = Math.max(tmp1,tmp0 - prices[i-1]);
        }

        return dp_0_0;
    }
}
