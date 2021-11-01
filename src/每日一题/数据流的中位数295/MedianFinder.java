package 每日一题.数据流的中位数295;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    /** initialize your data structure here. */
    // 优先队列，大于中位数的小顶堆，小于中位数的大顶堆
    Queue<Integer> q1 = new PriorityQueue<>();// 小顶堆
    Queue<Integer> q2 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });// 大顶堆

    double result = 0.0;
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(q1.size() == 0 && q2.size() == 0){
            // 第一个push进来的值
            q1.offer(num);
            result = num;
        }else if(q2.size() == 0){
            q2.offer(num);
            result = (q1.peek()+ q2.peek())/2.0;
        }else{
            if(num>=result){
                q1.offer(num);
            }else{
                q2.offer(num);
            }
        }
    }

    public double findMedian() {

    }
}
