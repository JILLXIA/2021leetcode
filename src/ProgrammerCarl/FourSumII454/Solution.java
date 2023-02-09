package ProgrammerCarl.FourSumII454;

import java.util.HashMap;

/**
 * Given four integer arrays nums1, nums2, nums3,
 * and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // use HashMap to store the sum and the frequency of each sum occur.
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num1: nums1){
            for(int num2: nums2){
                map.put(num1+num2, map.getOrDefault(num1+num2,0)+1);
            }
        }

        int result = 0;
        for(int num3: nums3){
            for(int num4: nums4){
                if(map.containsKey(-num3-num4)){
                    result += map.get(-num3-num4);
                }
            }
        }

        return result;
    }
}
