package Top100Question.MaximumProductSubarray152;

/**
 * Given an integer array nums,
 * find a subarray that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int result = maxDp[0];
        for(int i = 1;i<nums.length;i++){
            maxDp[i] = Math.max(maxDp[i-1] * nums[i], Math.max(minDp[i-1] * nums[i], nums[i]));
            minDp[i] = Math.min(maxDp[i-1] * nums[i], Math.min(minDp[i-1] * nums[i], nums[i]));
            result = Math.max(result, maxDp[i]);
        }
        return result;
    }
}
