package labuladong.PartitionToKEqualSumSubsets698;


import java.util.HashMap;

/**
 * Given an integer array nums and an integer k,
 * return true if it is possible to divide this array
 * into k non-empty subsets whose sums are all equal.
 */
public class Solution {
	HashMap<Integer, Boolean> memo = new HashMap<>();
	public boolean canPartitionKSubsets(int[] nums, int k) {
		// there are k bucket
		// whether nums[i] will comes into kth bucket

		// use a Integer to notify whether the nums[i] has been selected
		int used = 0;
		int sum = 0;
		for(int i:nums){
			sum += i;
		}
		if(sum % k != 0){
			return false;
		}

		int target = sum / k;
		return backTrace(nums, k, target,0,0, used);
	}

	public boolean backTrace(int[] nums, int k, int target, int start, int tmpSum, int used){
		if(k==0){
			return true;
		}

		if(tmpSum == target){
			boolean res = backTrace(nums, k-1, target, 0,0, used);
			memo.put(used,res);
			return res;
		}

		if(memo.containsKey(used)){
			return memo.get(used);
		}

		for(int i = start;i<nums.length;i++){
			// if has visited, continue
			if(((used >> i) & 1)==1){
				continue;
			}

			if(tmpSum + nums[i] > target){
				continue;
			}
			// add nums[i] to this bucket
			int tmpUsed = used;
			used = (1 << i) | used;
			// 每选一个数就进入一个新的回溯
			if(backTrace(nums, k, target, i+1,tmpSum + nums[i],used)){
				return true; // 直接进入下一个递归
			}
			used = tmpUsed;
		}
		return false;
	}
}
