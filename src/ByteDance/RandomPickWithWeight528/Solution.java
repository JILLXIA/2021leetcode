package ByteDance.RandomPickWithWeight528;

import java.util.Random;
import java.util.TreeMap;

public class Solution {
    int sumAll;
    // binary search.
    TreeMap<Integer, Integer> map;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        sumAll = 0;
        map = new TreeMap();
        for(int i = 0;i<w.length;i++){
            sumAll += w[i];
            map.put(sumAll, i);
        }
    }

    public int pickIndex() {
        int pick = random.nextInt(sumAll)+1;
        return map.get(map.ceilingKey(pick));
    }
}
