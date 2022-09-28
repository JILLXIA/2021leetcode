package Google.RandomPickWithWeight528;

import java.util.Random;
import java.util.TreeMap;

/**
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 *
 * You need to implement the function pickIndex(),
 * which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it.
 * The probability of picking an index i is w[i] / sum(w).
 *
 * For example, if w = [1, 3], the probability of picking index
 * 0 is 1 / (1 + 3) = 0.25 (i.e., 25%),
 * and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 */
public class Solution {
    // TreeMap key
    // int[] weight;
    TreeMap<Integer, Integer> map;
    Random random;
    int sumAll;
    public Solution(int[] w) {
        // this.weight = w;
        random = new Random();
        map = new TreeMap<>();
        int sum = 0;
        for(int i = 0;i<w.length;i++){
            sum += w[i];
            map.put(sum,i);
        }
        this.sumAll = sum;
    }

    public int pickIndex() {
        int randonInt = random.nextInt(this.sumAll)+1;
        return map.get(map.ceilingKey(randonInt));
    }

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{4,2});
        System.out.println(s.pickIndex());

    }
}
