package labuladong.SubarraySumEqualsK560;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of subarrays whose sum equals to k.
 */
public class Solution {
	public int subarraySum(int[] nums, int k) {
		int[] preSum = new int[nums.length+1];
		for(int i = 1;i< preSum.length;i++){
			preSum[i] = preSum[i-1] + nums[i-1];
		}

		int result = 0;
		for(int i = 0;i< preSum.length;i++){
			for(int j = i+1;j< preSum.length;j++){
				if(preSum[j]-preSum[i]==k){// 类似two sum,可以用hashMap进行优化
					// 有多少个前缀和满足 k+preSum[i]
					result++;
				}
			}
		}
		return result;
	}
}
