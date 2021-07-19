package 动态规划.买卖股票的最佳时机121;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Solution {
	public int maxProfit(int[] prices) {
		if(prices.length==0) {
			return 0;
		}
		int minNum = prices[0];
		int result = 0;
		for(int i = 1;i<prices.length;i++){
			if(prices[i]<minNum){
				minNum = prices[i];
			}
			result = result<prices[i]-minNum ? prices[i]-minNum : result;
		}
		return result;

	}
}
