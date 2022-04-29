package 贪心算法.JumpGameII45;

/**
 * Given an array of non-negative integers nums, you are initially
 * positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at
 * that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 */
public class Solution {
	public int jump(int[] nums) {
		int result = 0;
		int x_end = nums[0];
		int curr_end = x_end;
		for(int i = 1;i<nums.length-1;i++){ // 最后一个不用遍历
			x_end = Math.max(nums[i] + i,x_end);
			if(curr_end == i){
				result++;
				curr_end = x_end;
			}
		}
		return result;
	}
}
