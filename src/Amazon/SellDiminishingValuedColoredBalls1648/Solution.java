package Amazon.SellDiminishingValuedColoredBalls1648;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class Solution {
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int result = 0;
        for(int i = 0;i<inventory.length;i++){
            pq.add(inventory[i]);
        }

        while(orders > 0){
            int tmp = pq.poll();
            result = (result +  tmp)%1000000007;
            pq.add(tmp - 1);
            orders--;
        }
        return result;
    }
}
