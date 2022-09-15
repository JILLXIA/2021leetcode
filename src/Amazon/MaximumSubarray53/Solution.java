package Amazon.MaximumSubarray53;

public class Solution {
    public int maxSubArray(int[] nums) {
        // dp问题求最值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i = 1;i<nums.length;i++){
            if(dp[i-1] + nums[i] <= 0){
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
