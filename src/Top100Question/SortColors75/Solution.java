package Top100Question.SortColors75;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 */
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left;
        while(mid <= right){
            if(nums[mid]==0){
                swap(nums, left, mid);
                left++;
                mid++;
            } else if(nums[mid]==2){
                swap(nums, mid, right);
                right--;
            } else {
                mid++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
