package ProgrammerCarl.IntersectionOfTwoArrays349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may
 * return the result in any order.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums1.length;i++){
            set.add(nums1[i]);
        }

        HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < nums2.length;i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        int[] ans = new int[result.size()];
        int index = 0;
        for(Integer i: result){
            ans[index++] = (int)i;
        }
        return ans;
    }
}
