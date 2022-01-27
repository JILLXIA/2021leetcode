package 动态规划.动态规划21天初级.第N天.环形子数组的最大和918;

import java.util.Arrays;

/**
 * 给定一个由整数数组 A表示的环形数组 C，求 C的非空子数组的最大可能和。
 *
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。
 * （形式上，当0 <= i < A.length时C[i] = A[i]，
 * 且当i >= 0时C[i+A.length] = C[i]）
 *
 * 此外，子数组最多只能包含固定缓冲区 A中的每个元素一次。
 * （形式上，对于子数组C[i], C[i+1], ..., C[j]，
 * 不存在i <= k1, k2 <= j其中k1 % A.length= k2 % A.length）
 */

// 憨憨
public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] arr = new int[2*nums.length-1];
        for(int i = 0;i<arr.length;i++){
            arr[i] = i>=nums.length ?nums[(i-nums.length)%nums.length]: nums[i%nums.length];
        }
        return maxSubArray(arr);
    }

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

    public static void main(String[] args){
        Solution s = new Solution();
        s.maxSubarraySumCircular(new int[]{5,-3,5});
    }
}
