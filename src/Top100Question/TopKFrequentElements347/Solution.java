package Top100Question.TopKFrequentElements347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an integer array nums and an integer k,
 * return the k most frequent elements. You may return the answer in any order.
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        // bucket sort; time complexity is O(n)
        ArrayList<Integer>[] bucket = new ArrayList[nums.length];
        for(int key: map.keySet()){
            int value = map.get(key);
            if(bucket[value]==null){
                bucket[value] = new ArrayList();
            }
            bucket[value].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for(int pos = bucket.length - 1; pos >= 0 && result.size() < k;pos--){
            if(bucket[pos] != null){
                result.addAll(bucket[pos]);
            }
        }

        int[] ans = new int[k];
        for(int i = 0;i<ans.length;i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}
