package 动态规划.零钱兑换II518;

/**
 * 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。
 * 假设每一种面额的硬币有无限个。
 */

/**
 * 组合优化问题，找全局最优
 *
 * 定义 f[i][j] 为考虑前 i 件物品，凑成总和为 j 的方案数量。
 *
 * 为了方便初始化，我们一般让 f[0][x] 代表不考虑任何物品的情况。
 *
 * 因此我们有显而易见的初始化条件：f[0][0] = 1，
 * 其余 f[0][x] = 0。
 *
 * 代表当没有任何硬币的时候，
 * 存在凑成总和为 0 的方案数量为 1；凑成其他总和的方案不存在。
 *
 * 当「状态定义」与「基本初始化」有了之后，
 * 我们不失一般性的考虑 f[i][j] 该如何转移。
 *
 * 对于第 i 个硬币我们有两种决策方案：
 * 1.不使用该硬币：f[i−1][j]
 * 2.使用该硬币：k=1
 * ∑⌊j/val⌋f[i−1][j−k∗val],val=nums[i−1]
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i = 1;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
/*
        for(int i = 1;i<=coins.length;i++){
            int val = coins[i-1];
            for(int j = 0;j<=amount;j++){
                dp[i][j] = dp[i-1][j];
                for(int k = 1;k*val<=j;k++){
                    dp[i][j] += dp[i-1][j-k*val];
                }
            }
        }

 */
        //内外两层循环可以调换位置哦
        for(int j = 0;j<=amount;j++){
            for(int i = 1;i<=coins.length;i++){
                int val = coins[i-1];
                dp[i][j] = dp[i-1][j];
                for(int k = 1;k*val<=j;k++){
                    dp[i][j] += dp[i-1][j-k*val];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
