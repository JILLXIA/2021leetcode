package 动态规划.斐波拉切数509;

/**
 * 斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 */

/**
 * 如果直接递归的话会产生冗余的计算
 * 可以使用动态规划或者备忘录的递归函数
 */
public class Solution {
    /**
     * 或者只记录前面两个数，可以减少空间复杂度
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
