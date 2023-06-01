package ProgrammerCarl.MaximumSubarray53;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int[] dp = new int[nums.length + 1];

        for(int i = 0;i < nums.length;i++){
            if(dp[i] >= 0) {
                dp[i+1] = dp[i] + nums[i];

            } else {
                dp[i+1] = nums[i];
            }
            result = Math.max(result, dp[i+1]);
        }
        return result;
    }
}
