package Top100Question.IncreasingTripletSubsequence334;

/**
 * Given an integer array nums,
 * return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;

        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= max1){
                max1 = nums[i];
            } else if(nums[i] <= max2){
                max2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
