package labuladong.BinarySearch704;

public class Solution1 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length; // 注意
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1; // 注意
            } else if(nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return -1;
    }
}
