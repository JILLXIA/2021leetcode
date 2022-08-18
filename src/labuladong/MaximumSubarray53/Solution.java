package labuladong.MaximumSubarray53;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */
public class Solution {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int result = dp[0];
		for(int i = 1;i<nums.length;i++){
			if(dp[i-1]<0){
				dp[i] = nums[i];
			} else {
				dp[i] = dp[i-1] + nums[i];
			}
			result = Math.max(result,dp[i]);
		}
		return result;
	}
}
