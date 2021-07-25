package 动态规划.丑数II264;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution1 {
    //PriorityQueue可以自动维护一个最小堆，但是不能判断元素在不在，
    // 所以还要搞一个set来辅助判断
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int[] arr = {2,3,5};
        queue.add(1L);
        set.add(1L);
        for(int i = 1;i<n;i++){
            Long tmp = queue.peek();
            if(queue.size()<n) {
                for (int j = 0; j < arr.length; j++) {
                    if (!set.contains(tmp * arr[j])) {
                        set.add(tmp * arr[j]);
                        queue.add(tmp * arr[j]);
                    }
                }
            }
            queue.poll();
        }
        return Integer.parseInt(String.valueOf(queue.peek()));
    }
}
