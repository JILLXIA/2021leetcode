package labuladong.SplitArrayLargestSum410;

/**
 * Given an array nums which consists of non-negative integers
 * and an integer m, you can split the array into
 * m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum
 * among these m subarrays.
 */
public class Solution {
	public int splitArray(int[] nums, int m) {
		int left = 0;
		int right = 1;
		for(int num:nums){
			left = Math.max(left,num);
			right += num;
		}

		while(left<right){
			int mid = left + (right - left)/2;
			int compareTimes = f(nums, mid);
			if(compareTimes==m){
				right = mid;
			} else if(compareTimes > m){
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
	public int f(int[] nums, int maxSum){
		// times of cut
		int tmpSum = 0;
		int times = 0;
		for(int num:nums){
			tmpSum += num;
			if(tmpSum==maxSum){
				times++;
				tmpSum = 0;
			} else if(tmpSum > maxSum){
				times++;
				tmpSum = num;
			}
		}
		return tmpSum > 0 ? times + 1: times;
	}
}
