package 动态规划.动态规划21天初级.第N天.最佳买卖股票时机含冷冻期309;

/**
 * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // 关注今天的股票的三个状态
        // dp[i][0] 不持股 且不卖出
        // dp[i][1] 持股
        // dp[i][2] 不持股且卖出

        // 只关注卖出的状态，不关心买入！！！
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for(int i = 1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }
}
