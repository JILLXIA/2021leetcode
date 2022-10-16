package ByteDance.RandomPickIndex398;

import java.util.Random;

/**
 * Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 *
 * Implement the Solution class:
 *
 * Solution(int[] nums) Initializes the object with the array nums.
 * int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should have an equal probability of returning.
 */
// Reservoir sampling
public class Solution {
    int[] nums;
    Random rd;
    public Solution(int[] nums) {
        this.nums = nums;
        rd = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==target){
                int tmp = rd.nextInt(count+1);
                if(tmp==0){
                    result = i;
                }
                count++;
            }
        }
        return result;
    }
}
