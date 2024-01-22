package Grind75.ContainsDuplicate217;

import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears
 * at least twice in the array,
 * and return false if every element is distinct.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }
}
