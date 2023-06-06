package ProgrammerCarl.JumpGame55;

/**
 * You are given an integer array nums.
 * You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump
 * length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int left = 0;
        int right = nums[0];

        while(right < nums.length - 1) {
            if(left >= right) {
                return false;
            }
            int nextRight = right;

            for(int i = left; i <= right;i++){
                nextRight = Math.max(nextRight, i + nums[i]);
            }
            left = right;
            right = nextRight;
        }

        return true;
    }
}
