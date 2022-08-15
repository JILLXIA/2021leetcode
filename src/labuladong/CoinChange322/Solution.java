package labuladong.CoinChange322;

import javax.xml.ws.spi.http.HttpHandler;
import java.util.Arrays;
import java.util.HashMap;

/**
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Solution {
	public int coinChange(int[] coins, int amount) {
		if(amount==0){
			return 0;
		}
		int[] dp = new int[amount+1];
		Arrays.fill(dp,-1);
		for(int i = 0;i<coins.length;i++){
			if(coins[i]>amount){
				continue;
			}
			dp[coins[i]]=1;
		}
		for(int i = 1;i <= amount;i++){
			int tmp = Integer.MAX_VALUE;
			if(dp[i]!=-1){
				continue;
			}
			for(int j = 0;j < coins.length;j++){
				if(i<=coins[j]){
					continue;
				}
				if(dp[i-coins[j]]==-1){
					continue;
				}
				tmp = Math.min(tmp, dp[i-coins[j]] + 1);
			}
			dp[i] = tmp == Integer.MAX_VALUE ? -1:tmp;
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.coinChange(new int[]{1},0));
	}
}
