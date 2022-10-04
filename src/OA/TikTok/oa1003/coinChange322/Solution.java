package OA.TikTok.oa1003.coinChange322;

import java.util.Arrays;

/**
 * 给出n个雨伞，每个雨伞能覆盖a[i]个人，
 * 有无限把，问m个人最少需要几把雨伞能覆盖掉
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // Arrays.sort(coins);
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{1,2,5},11));
    }
}
