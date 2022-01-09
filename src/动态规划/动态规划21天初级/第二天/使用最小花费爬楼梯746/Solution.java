package 动态规划.动态规划21天初级.第二天.使用最小花费爬楼梯746;

/**
 * 给你一个整数数组 cost ，其中 cost[i]
 * 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，
 * 即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int num0 = 0;
        int num1 = 0;

        int result = 0;
        for(int i = 2;i<=n;i++){
            result = Math.min(num0+cost[i-2],num1+cost[i-1]);
            num0 = num1;
            num1 = result;
        }
        return result;
    }
}
