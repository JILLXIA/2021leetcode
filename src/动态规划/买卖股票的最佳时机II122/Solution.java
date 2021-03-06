package 动态规划.买卖股票的最佳时机II122;

/**
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int minNum = prices[0];
        int maxNum = 0;

        int result = 0;

        for(int i = 1;i<prices.length;i++){
            if((i!=prices.length-1 && prices[i]>minNum && prices[i]>prices[i+1])
            || (i==prices.length-1 && prices[i]>minNum)){
                maxNum = prices[i];
                result += maxNum - minNum;
                minNum = prices[i];
            }else if(prices[i]<=minNum){
                minNum = prices[i];
            }
        }
        return result;
    }
}
