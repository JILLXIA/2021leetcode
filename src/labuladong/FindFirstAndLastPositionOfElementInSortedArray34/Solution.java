package labuladong.FindFirstAndLastPositionOfElementInSortedArray34;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		int[] result = new int[2];
		if(nums.length==0){
			return new int[]{-1,-1};
		}
		while(left < right){
			int mid = left + (right-left)/2;
			if(nums[mid]==target){
				right = mid;
			} else if(nums[mid] < target){
				left = mid + 1;
			} else if(nums[mid] > target){
				right = mid;
			}
		}
		// 检查outofbounds的情况
		result[0] =  (left < nums.length && nums[left]==target) ? left : -1;
		right = nums.length;
		while(left < right){
			int mid = left + (right-left)/2;
			if(nums[mid]==target){
				left = mid + 1;
			} else if(nums[mid] < target){
				left = mid + 1;
			} else if(nums[mid] > target){
				right = mid;
			}
		}
		result[1] = (left >0 && nums[left-1]==target) ? left-1 : -1;
		return result;
	}
}
