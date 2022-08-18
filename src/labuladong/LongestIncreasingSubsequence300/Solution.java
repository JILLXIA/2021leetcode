package labuladong.LongestIncreasingSubsequence300;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting
 * some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */
public class Solution {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int result = 0;
		for(int i = 1;i<nums.length;i++){
			int tmp = 1;
			for(int j = 0;j<i;j++){
				if(nums[i] > nums[j]){
					tmp = Math.max(tmp,dp[j]+1);
				}
			}
			dp[i] = tmp;
			result = Math.max(result,dp[i]);
		}
		return result;
	}
}
