package 每日一题.第K个最小的素数分数786;

import java.util.PriorityQueue;

/**
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。
 * 数组 arr 由 1 和若干 素数组成，且其中所有整数互不相同。
 *
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 *
 * 那么第k个最小的分数是多少呢?以长度为 2 的整数数组返回你的答案,
 * 这里answer[0] == arr[i]且answer[1] == arr[j] 。
 */
public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 多路并归，留指针记录每一路的进度，用小根堆，第k个pop出来的元素就是答案
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->arr[a[0]]*arr[b[1]]-arr[a[1]]*arr[b[0]]);

        // 先把每一路的第一个元素放进queue里面
        for(int i = 1;i<arr.length;i++){
            queue.add(new int[]{0,i});
        }

        // queue里面存的是指针
        int count = 0;
        while(true){
            int[] tmp = queue.poll();
            count++;
            if(count==k){
                return new int[]{arr[tmp[0]],arr[tmp[1]]};
            }
            if(tmp[0]+1<tmp[1]) {
                queue.offer(new int[]{tmp[0] + 1, tmp[1]});
            }
        }
    }
}
