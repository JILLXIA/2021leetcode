package labuladong.LongestConsecutiveSequence128;

import java.util.Arrays;

/**
 * Given an unsorted array of integers nums,
 * return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */
public class Solution {
	public int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		int left = 0;
		int right = 0;
		int result = 0;
		int repetition = 0;
		while (left < nums.length && right < nums.length) {
			while (right + 1 < nums.length && nums[right + 1] - nums[right] <= 1) {
				if (nums[right + 1] - nums[right] == 0) {
					repetition++;
				}
				right++;
			}
			int tmpSize = right - left + 1 - repetition;
			repetition = 0;
			result = Math.max(result,tmpSize);
			left = right + 1;
			right = left;
		}
		return result;
	}
}
