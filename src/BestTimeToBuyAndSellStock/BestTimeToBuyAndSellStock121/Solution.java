package BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStock121;

/**
 * You are given an array prices where prices[i] is
 * the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day
 * to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int dp_0_0 = 0;
        int dp_0_1 = Integer.MIN_VALUE;
        for(int i = 1;i<=prices.length;i++){
            dp_0_0 = Math.max(dp_0_0,dp_0_1 + prices[i-1]);
            dp_0_1 = Math.max(dp_0_1,-prices[i-1]);
        }
        return dp_0_0;
    }
}
