package 动态规划.超级丑数313;

import java.util.Arrays;

/**
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 *
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 *
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 */

/**
 * 做法和丑数类似，只是把index变成了一个数组而已
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        Arrays.fill(index,1);

        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            int minTemp = Integer.MAX_VALUE;
            for(int j = 0;j<index.length;j++){
                minTemp = Math.min(minTemp,dp[i-index[j]] * primes[j]);
            }

            for(int j = 0;j<index.length;j++){
                if(minTemp != dp[i-index[j]] * primes[j]){
                    index[j]++;
                }
            }
            dp[i] = minTemp;
        }
        return dp[n];
    }
}
