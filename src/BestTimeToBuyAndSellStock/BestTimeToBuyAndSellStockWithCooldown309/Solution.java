package BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockWithCooldown309;

/**
 * You are given an array prices where prices[i]
 * is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class Solution {
//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length+1][3];
//
//        dp[0][0] = 0;
//        dp[0][1] = Integer.MIN_VALUE;
//        dp[0][2] = Integer.MIN_VALUE;
//
//        for(int i = 1;i<dp.length;i++){
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
//            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i-1]);
//            dp[i][2] = dp[i-1][1] + prices[i-1];
//        }
//
//        return Math.max(dp[dp.length-1][0],dp[dp.length-1][2]);
//    }

    public int maxProfit(int[] prices) {
        int dp_0_0 = 0;
        int dp_0_1 = Integer.MIN_VALUE;
        int dp_0_2 = Integer.MIN_VALUE;

        for(int i = 1;i<=prices.length;i++){
            int tmp0 = dp_0_0;
            int tmp1 = dp_0_1;
            int tmp2 = dp_0_2;
            dp_0_0 = Math.max(tmp0, tmp2);
            dp_0_1 = Math.max(tmp1,tmp0 - prices[i-1]);
            dp_0_2 = tmp1 + prices[i-1];
        }

        return Math.max(dp_0_0,dp_0_2);
    }
}
