package 动态规划.动态规划21天初级.第N天.打家劫舍II213;

import java.util.Arrays;

public class Solution {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，
     * 每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
     * 系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，
     * 计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
    public int rob(int[] nums) {
        // 对于数值类型的数组是深拷贝，对于引用类型是浅拷贝。如果是引用里面的类型是不变的
        if(nums.length==1){
            return nums[0];
        }
        int[] arr1 = Arrays.copyOfRange(nums,0,nums.length-1);
        int[] arr2 = Arrays.copyOfRange(nums,1,nums.length);
        return Math.max(rob1(arr1),rob1(arr2));
    }
}
