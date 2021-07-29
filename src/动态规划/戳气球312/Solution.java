package 动态规划.戳气球312;

/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，
 * 这些数字存在数组nums中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，
 * 你可以获得nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。
 * 如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 */

/**
 * 区间动态规划，用dp[i][j]来表示
 * 由小区间慢慢扩充到大区间
 *
 * 这道题为了简化边界情况，应该首位都增加一个哑节点
 */
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[nums.length+2];
        temp[0] = 1;
        temp[n+1] = 1;
        for(int i = 1;i<=n;i++){
            temp[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];

        for(int len = 3;len<=n+2;len++){//一开始初始状态长度肯定为3
            // 最外层的循环控制长度

            for(int i = 0;i<=n+2-len;i++){//枚举起点
                for(int k = i+1;k<i+len-1;k++){
                    dp[i][i+len-1] = Math.max(dp[i][i+len-1],
                            dp[i][k]+temp[i]*temp[k]*temp[i+len-1]+dp[k][i+len-1]);
                }
            }
        }
        // 上面三层循环相当于是一个区间dp的模版 之后的题目可以往里面带
        return dp[0][n+1];
    }

    public static void main(String[] args){
        Solution s = new Solution();
        s.maxCoins(new int[]{3,1,5,8});
    }
}
