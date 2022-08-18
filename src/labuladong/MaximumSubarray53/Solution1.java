package labuladong.MaximumSubarray53;

public class Solution1 {
	public int maxSubArray(int[] nums) {
		// int[] dp = new int[nums.length];
		int dp_0 = nums[0];
		int result = dp_0;
		int dp_1 = dp_0;
		for(int i = 1;i<nums.length;i++){
			if(dp_0<0){
				dp_1 = nums[i];
			} else {
				dp_1 = dp_0 + nums[i];
			}
			result = Math.max(result,dp_1);
			dp_0 = dp_1;
		}
		return result;
	}
}
