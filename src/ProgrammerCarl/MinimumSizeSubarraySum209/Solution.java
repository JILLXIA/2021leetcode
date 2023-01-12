package ProgrammerCarl.MinimumSizeSubarraySum209;

/**
 * Given an array of positive integers nums
 * and a positive integer target,
 * return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target.
 *  If there is no such subarray, return 0 instead.
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;

        int sum = 0;
        int result = Integer.MAX_VALUE;
        // time: O(n), space: O(1)
        while(right < nums.length){
            sum += nums[right];
            right++;
            while(sum >= target){
                result = Math.min(result, right - left);
                sum -= nums[left];
                left++;
            }

        }
        return result==Integer.MAX_VALUE ? 0 : result;
    }
}
