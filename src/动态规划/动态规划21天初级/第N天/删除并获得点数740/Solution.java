package 动态规划.动态规划21天初级.第N天.删除并获得点数740;

import java.util.Arrays;

/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class Solution {
    // 转化为打家劫舍问题
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        int maxValue = -1;
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]] = arr[nums[i]] + nums[i];
            maxValue = Math.max(maxValue,nums[i]);
        }
        return rob1(Arrays.copyOfRange(arr,1,maxValue+1));
    }

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

}
