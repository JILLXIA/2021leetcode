package Top100Question.SearchInRotatedSortedArray33;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function,
 * nums is possibly rotated at an unknown pivot index k
 * (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class Solution {
    public int search(int[] nums, int target) {
        // 找出最小值的点
        int minIndex = findMin(nums);
        int left = 0;
        int right = nums.length - 1;
        if(minIndex==0){
            // 不一定所有的情形都是两段递增的
            // 也有可能是只有一段递增
            ;
        }
        else if(target > nums[left]){
            right = minIndex - 1;
        } else if(target < nums[left]){
            left = minIndex;
        } else {
            return left;
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid]==target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findMin(int[] nums){
        // find the minimum value's index
        int left = 0;
        int right = nums.length - 1;
        if(nums.length==1 || nums[left] < nums[right]){
            return 0;
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                return mid + 1;
            } else if(nums[mid] >= nums[left]){
                left = mid + 1;
            } else if(nums[mid] < nums[left]){
                right = mid - 1;
            }
        }
        return -1;
    }
}
