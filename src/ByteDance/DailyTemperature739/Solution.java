package ByteDance.DailyTemperature739;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] nextBigger = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList();
        // decreasing
        //  73.      8
        //  73 76.   8
        //  73 76 72        6
        //  73 76 72 69        5
        //  73 76 72. 71          5
        //  73 76  75              6
        //  73 76  75 74              2
        //. 73 76  75 74 73             1

        // index - nextBigger[index]

        for(int i = temperatures.length - 1;i>=0;i--){
            while(!deque.isEmpty() && temperatures[deque.peekLast()] <= temperatures[i]){
                deque.pollLast();
            }
            nextBigger[i] = deque.isEmpty() ? i : deque.peekLast();
            deque.offerLast(i);
        }

        int[] result = new int[temperatures.length];
        for(int i = 0;i<result.length;i++){
            result[i] = nextBigger[i] - i;
        }
        return result;
    }
}
