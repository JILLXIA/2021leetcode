package labuladong.DaliyTemperatures739;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        // monotonic stack
        int[] result = new int[temperatures.length];
        Deque<int[]> deque = new LinkedList<>();

        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!deque.isEmpty() && temperatures[i] >= deque.peekFirst()[0]) {
                deque.pollFirst();
            }
            result[i] = deque.isEmpty() ? 0 : (deque.peekFirst()[1] - i);
            deque.offerFirst(new int[]{temperatures[i], i});
        }
        return result;
    }
}
