package codeSignal.FindingPairsWithACertainSum1865;

import java.util.HashMap;

/**
 * You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:
 *
 * Add a positive integer to an element of a given index in the array nums2.
 * Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
 * Implement the FindSumPairs class:
 *
 * FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
 * void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
 * int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] nums2;
    public Solution(int[] nums1, int[] nums2) {
        for(int i = 0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        nums2[index] += val;
    }

    public int count(int tot) {
        int result = 0;
        for(int i = 0;i<nums2.length;i++){
            if(map.containsKey(tot - nums2[i])){
                result += map.get(tot - nums2[i]);
            }
        }
        return result;
    }
}
