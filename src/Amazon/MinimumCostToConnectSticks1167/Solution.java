package Amazon.MinimumCostToConnectSticks1167;

import java.util.PriorityQueue;

/**
 * You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.
 *
 * You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.
 *
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 */
public class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:sticks){
            pq.add(i);
        }
        int result = 0;
        while(pq.size() > 1){
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();
            result += tmp1 + tmp2;
            pq.add(tmp1 + tmp2);
        }
        return result;
    }
}
