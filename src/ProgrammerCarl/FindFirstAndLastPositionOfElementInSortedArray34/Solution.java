package ProgrammerCarl.FindFirstAndLastPositionOfElementInSortedArray34;

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
        // check if nums[left] or nums[right] equals to target

        int leftRange = 0;
        int rightRange = nums.length;

        int left = 0;
        int right = nums.length;

        while(left < right){
            // left range
            int mid = left + (right - left) / 2;

            if(nums[mid] >= target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        leftRange = (left < nums.length && nums[left]==target && left <= right) ? left : -1;

        left = 0;
        right = nums.length;

        while(left < right){
            // right range
            int mid = left + (right - left) / 2;

            if(nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        rightRange = (left - 1 >= 0 && nums[left-1]==target && left <= right) ? left-1 : -1;
        return new int[]{leftRange, rightRange};
    }
}
