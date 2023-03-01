package ProgrammerCarl.TopKFrequentElements347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an integer array nums and an integer k,
 * return the k most frequent elements. You may return the answer in any order.
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // bucket sort O(n)
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> freq

        for(int i = 0; i < nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];

        for(int key: map.keySet()){
            if(bucket[map.get(key)] == null){
                bucket[map.get(key)] = new ArrayList<Integer>();
            }
            bucket[map.get(key)].add(key);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = bucket.length-1;i >= 0;i--){
            if(result.size() == k){
                break;
            }
            if(bucket[i] != null){
                for(Integer j: bucket[i]){
                    result.add(j);
                }
            }
        }

        int[] ans = new int[k];
        for(int i = 0;i<result.size();i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}
