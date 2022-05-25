package labuladong.FindMedianFromDataStream295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
public class MedianFinder {
	PriorityQueue<Integer> bigPeak;
	PriorityQueue<Integer> smallPeak;
	double result;
	public MedianFinder() {
		smallPeak = new PriorityQueue<>(); // 默认是小顶堆
		bigPeak = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		this.result = 100001; // initial the result
	}

	public void calculateResult() {
		//There will be at least one element in the data structure before calling findMedian.
		if(smallPeak.size()== bigPeak.size()) {
			this.result = (smallPeak.peek() + bigPeak.peek()) / 2.0;
		} else if(smallPeak.size() > bigPeak.size()){
			this.result = smallPeak.peek();
		} else {
			this.result = bigPeak.peek();
		}
	}

	public void addNum(int num) {
		// 一开始默认加入大顶堆
		if(num <= this.result){
			// 如果比中位数小，加入大顶堆，反之加入小顶堆
			bigPeak.add(num);
		} else {
			smallPeak.add(num);
		}

		// 调整两个堆的大小
		if(bigPeak.size()-smallPeak.size()>=2){
			int tmp = bigPeak.poll();
			smallPeak.add(tmp);
		} else if(smallPeak.size()-bigPeak.size()>=2){
			int tmp = smallPeak.poll();
			bigPeak.add(tmp);
		}
		calculateResult();
	}

	public double findMedian() {
		return this.result;
	}
}
