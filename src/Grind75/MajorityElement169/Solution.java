package Grind75.MajorityElement169;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0) {
                count = 1;
                major = nums[i];
            } else if(nums[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
