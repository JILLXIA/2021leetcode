package ProgrammerCarl.MaximizeSumOfArrayAfterKNegations1005;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer k, modify the array in the following way:
 *
 * choose an index i and replace nums[i] with -nums[i].
 * You should apply this process exactly k times. You may choose the same index i multiple times.
 *
 * Return the largest possible sum of the array after modifying it in this way.
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        if(nums[0] >= 0 && k % 2 != 0) {
            nums[0] = -nums[0];
        } else if(nums[0] < 0){
            int index = 0;
            for(int i = 0;i < nums.length;i++){
                
            }
        }
        return 0;
    }
}
