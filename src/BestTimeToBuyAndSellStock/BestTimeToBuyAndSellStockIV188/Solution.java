package BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockIV188;

/**
 * You are given an integer array prices where prices[i]
 * is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve.
 * You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions
 * simultaneously (i.e., you must sell the stock before you buy again).
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k > prices.length/2){
            return maxProfit2(prices);
        }
        return maxProfit1(prices, k);
    }

    public int maxProfit1(int[] prices, int k) {
        int[][][] dp = new int[prices.length][k+1][2];
        for(int i = 0;i<dp.length;i++){
            for(int j = 1;j<=k;j++){
                if(i==0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i]; // 第0天买入的钱
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[dp.length-1][k][0];
    }

    public int maxProfit2(int[] prices) {
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
