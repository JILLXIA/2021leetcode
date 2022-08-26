package BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockWithTransaction714;

/**
 * You are given an array prices where prices[i]
 * is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions
 * simultaneously (i.e., you must sell the stock before you buy again).
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp_0_0 = 0;
        int dp_0_1 = Integer.MIN_VALUE;
        for(int i = 1;i<= prices.length;i++){
            int tmp0 = dp_0_0;
            int tmp1 = dp_0_1;
            dp_0_0 = Math.max(tmp0,tmp1 + prices[i-1]);
            dp_0_1 = Math.max(tmp1,tmp0 - prices[i-1]-fee);
        }
        return dp_0_0;
    }
}
