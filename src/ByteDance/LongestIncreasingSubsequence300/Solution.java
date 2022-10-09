package ByteDance.LongestIncreasingSubsequence300;

import java.util.TreeMap;

/**
 * Given an integer array nums, return the length of the
 * longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from
 * an array by deleting some or no elements
 * without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // patience sorting
        int piles = 0;
        int[] topping = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            // find left most piles
            int left = 0;
            int right = piles;
            int poker = nums[i];
            while(left < right){
                int mid = left + (right - left) / 2;
                if(poker < topping[mid]){
                    right = mid;
                } else if(poker == topping[mid]){
                    right = mid;
                } else if(poker > topping[mid]){
                    left = mid + 1;
                }
            }

            if(left==piles){
                piles++;
            }
            topping[left] = poker;
        }
        return piles;
    }
}
