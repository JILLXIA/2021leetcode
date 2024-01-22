package Grind75.FindFirstAndLastPositionOfElementInSortedArray34;

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

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                right = mid;
            } else if(nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // 左边界和右边界检查出界情况的条件不一样
        int leftValue = (left < nums.length && nums[left] == target) ? left : -1;

        left = 0;
        right = nums.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int rightValue = (left - 1 > 0 && nums[left-1] == target) ? left-1 : -1;
        return new int[]{leftValue, rightValue};
    }
}
