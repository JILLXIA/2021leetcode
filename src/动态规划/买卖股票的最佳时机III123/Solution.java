package 动态规划.买卖股票的最佳时机III123;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //简化为4中状态buy1,sell1,buy2,sell2
        int buy1  = -prices[0];
        int sell1  = 0;
        int buy2  = -prices[0];
        int sell2  = 0;

        //难点在与找到状态转移方程，有四个不同的状态，每个状态都有方程，分清楚状态
        for(int i = 1;i<prices.length;i++){
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1,buy1+prices[i]);
            buy2 = Math.max(buy2,sell1-prices[i]);
            sell2 = Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }
}
