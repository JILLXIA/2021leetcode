package 动态规划.完全平方数279;

/**
 * 给定正整数n，找到若干个完全平方数
 * （比如1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class Solution {
    //本质上是零钱兑换问题
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2;i<dp.length;i++){
            dp[i] = i;//初始化为为最大值，全都是1的情况
            for(int j = 1;i-j*j>=0;j++){//不要用Math.sqrt太耗时间了
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
