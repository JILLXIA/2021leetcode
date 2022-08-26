package BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockIII123;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions
 * simultaneously (i.e., you must sell the stock before you buy again).
 */
public class Solution {
    // 注释里的方法是错误的
//    public int maxProfit(int[] prices) {
//        int k = 2;
//        int[][][] dp = new int[prices.length][k+1][2];
//
//        for(int i = 1;i<=k;i++){
//            dp[0][i][0] = 0;
//            dp[0][i][1] = Integer.MIN_VALUE;
//        }
//        for(int i = 1;i<dp.length;i++){
//            for(int j = 1;j<=k;j++){
//                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
//                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
//            }
//        }
//        return dp[dp.length-1][k][0];
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(s.maxProfit1(new int[]{1,2,3,4,5}));

    }
    public int maxProfit1(int[] prices) {
        int k = 2;
        int[][][] dp = new int[prices.length][k+1][2];
        for(int i = 0;i<dp.length;i++){
            for(int j = 1;j<=k;j++){
                if(i==0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[dp.length-1][k][0];
    }
}
