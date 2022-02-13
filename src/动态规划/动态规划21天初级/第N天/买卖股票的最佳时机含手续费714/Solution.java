package 动态规划.动态规划21天初级.第N天.买卖股票的最佳时机含手续费714;

/**
 * 给定一个整数数组prices，其中 prices[i]表示第i天的股票价格 ；
 * 整数fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 不持股，不卖股
        // 持股
        // 不持股，卖股

        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -fee-prices[0];
        dp[0][2] = 0;

        for(int i = 1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1],Math.max(dp[i-1][0],dp[i-1][2])-fee-prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }
}
