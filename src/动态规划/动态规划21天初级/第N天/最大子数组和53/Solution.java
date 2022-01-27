package 动态规划.动态规划21天初级.第N天.最大子数组和53;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（
 * 子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
