package ByteDance.FindTheDuplicateNumber287;

/**
 * Given an array of integers nums containing n + 1 integers
 * where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and
 * uses only constant extra space.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        // cycle/indexing sort
        // 相当于在linkedlist里面找到环的起点
        // 两个快慢指针；相遇之后快指针回到起点

        int fast = 0;
        int slow = 0;

        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast){
                break;
            }
        }

        fast = 0;
        while(fast!=slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
