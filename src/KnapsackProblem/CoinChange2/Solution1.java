package KnapsackProblem.CoinChange2;

import java.util.Arrays;

public class Solution1 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        // bad case
        dp[0] = 1;

        for(int i = 1;i<=coins.length;i++){
            for(int j = 1;j<dp.length;j++){
                if(j-coins[i-1] >= 0){
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1];
    }
}
