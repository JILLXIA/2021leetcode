package Grind75.TwoSum1;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they
 * add up to target.
 *
 * You may assume that each input
 * would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap(); // element value to index
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
