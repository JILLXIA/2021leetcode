package ByteDance.FindFirstAndLastPositionOfElementInSortedArray34;

/**
 *
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftmost = -1;
        int rightmost = -1;
        if(nums.length==0){
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 找exact number的时候需要判断是否相等和越界
        // 如果不判断找到的就是左：大于她的 右：小于她的第一个
        leftmost = (left < nums.length && nums[left]==target) ? left: -1;
        // leftmost = left;

        left = 0;
        right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        rightmost = (left - 1 >=0 && nums[left - 1]==target) ? left - 1: -1;
        // rightmost = left - 1;
        return new int[]{leftmost, rightmost};
    }
}
