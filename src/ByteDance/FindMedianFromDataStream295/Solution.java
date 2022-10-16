package ByteDance.FindMedianFromDataStream295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    double median;
    public Solution() {
        median = 0.0;
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if(num <= median){
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if(maxHeap.size() - minHeap.size() > 1){
            int tmp = maxHeap.poll();
            minHeap.add(tmp);
        }

        if(minHeap.size() - maxHeap.size() > 1){
            int tmp = minHeap.poll();
            maxHeap.add(tmp);
        }
        calculateMedian();

    }

    public double findMedian() {
        return median;
    }

    public void calculateMedian(){
        if(maxHeap.size() > minHeap.size()){
            median = maxHeap.peek();
        }
        else if(maxHeap.size() < minHeap.size()){
            median = minHeap.peek();
        } else {
            median = ((double)maxHeap.peek() + (double)minHeap.peek()) / 2;
        }

    }
}
