package labuladong.CoinChange322;

import java.util.Arrays;

public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1); // default value is -1
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] > amount) {
                continue;
            } else{
                dp[coins[i]] = 1;
            }
        }

        for(int i = 1; i <= amount ;i++) {
            int tmp = Integer.MAX_VALUE;
            if(dp[i] != -1) {
                continue;
            }
            for(int j = 1; j < i; j++) {
                if(dp[j]==-1 || dp[i-j]==-1){
                    continue;
                }
                tmp = Math.min(tmp, dp[j] + dp[i-j]);
                dp[i] = tmp;
            }
        }
        return dp[amount];
    }
}
