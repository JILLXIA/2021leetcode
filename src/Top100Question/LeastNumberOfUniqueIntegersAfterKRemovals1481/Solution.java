package Top100Question.LeastNumberOfUniqueIntegersAfterKRemovals1481;

import java.util.HashMap;

/**
 * Given an array of integers arr and an integer k.
 * Find the least number of unique integers after removing exactly k elements.
 */
public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        int[] bucket = new int[arr.length];
        for(int key: map.keySet()){
            int value = map.get(key);
            bucket[value]++;
        }
        int remain = map.size();
        int index = 1;
        while(k > 0){
            if(k - index * bucket[index] >= 0){
                remain = remain - bucket[index];
                k = k - index * bucket[index];
                index++;
            } else {
                return remain - k / index;
            }
        }
        return remain;
    }
}
