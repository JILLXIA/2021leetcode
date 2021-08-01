package 动态规划.整数拆分343;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i<dp.length;i++){
            for(int j = 1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        return dp[n];
    }
}
