package codeSignal.FindingPairsWithACertainSum1865;

import java.util.HashMap;

public class Solution1 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] nums1;
    int[] nums2;
    public Solution1(int[] nums1, int[] nums2) {
        for(int i = 0;i<nums2.length;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
        this.nums1 = nums1;
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        map.put(nums2[index],map.getOrDefault(nums2[index],0)-1);
        nums2[index] += val;
        map.put(nums2[index],map.getOrDefault(nums2[index],0)+1);
    }

    public int count(int tot) {
        int result = 0;
        for(int i = 0;i<nums1.length;i++){
            if(map.containsKey(tot - nums1[i])){
                result += map.get(tot - nums1[i]);
            }
        }
        return result;
    }
}
