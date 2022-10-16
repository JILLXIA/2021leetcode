package ByteDance.JumpGame55;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        // 2,3,1,1,4
        // 2,3,1.     1,4
        // 0+2.  1+3.   2+ 1.   1,4
        // 4 > nums.length()
        int cur = 0;
        int next = nums[cur];
        int maxStep = 0;
        while(true){
            if(next >= nums.length-1){
                return true;
            }

            if(cur==next){
                return false;
            }
            for(int i = cur;i<=next;i++){
                maxStep = Math.max(maxStep,i + nums[i]);
            }
            cur = next;
            next = maxStep;
            maxStep = 0;
        }
        // return true;
    }
}
