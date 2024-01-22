package ProgrammerCarl.JumpGameII45;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1].
 * The test cases are generated such that you can reach nums[n - 1].
 */
public class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int result = 1;
        int left = 0;
        int right = nums[0];

        while(right < nums.length-1) {
            int nextRight = right;
            int nextLeft = 0;
            for(int i = left; i <= right; i++) {
                if(i + nums[i] > nextRight){
                    nextRight = Math.max(right, i + nums[i]);
                    nextLeft = i;
                }
            }
            left = nextLeft;
            right = nextRight;
            result++;
        }
        return result;
    }
}
