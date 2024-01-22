package Grind75.MaximumSubarray53;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int tmp = 0;

        for(int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            result = Math.max(result, tmp);

            if(tmp < 0) {
                tmp = 0;
            }
        }
        return result;
    }
}
