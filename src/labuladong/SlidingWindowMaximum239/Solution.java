package labuladong.SlidingWindowMaximum239;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an array of integers nums,
 * there is a sliding window of size k which is moving from the
 * very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 */
public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		// 找最大值一开始想到的是最大堆，但是由于这个是滑动窗口，需要从再从堆里拿出值。
		// 用单调队列更合适，队列头部就是最大值，比他小的都pop出去了
		// 每个元素push,pop了一次，时间复杂度是O(n)
		int left = 0;
		int right = 0;
		MonotonicQueue mq = new MonotonicQueue();
		ArrayList<Integer> result = new ArrayList<>();
		while(right < nums.length){
			if(right-left < k){
				mq.push(nums[right]);
				right++;
			}else {
				result.add(mq.max());
				mq.push(nums[right]);
				mq.pop(nums[left]);
				right++;
				left++;
			}
		}
		result.add(mq.max());
		int[] answer = new int[result.size()];
		for(int i = 0;i<answer.length;i++){
			answer[i] = result.get(i);
		}
		return answer;
	}
}

class MonotonicQueue{
	private Deque<Integer> deque = new LinkedList<>();
	public void push(int k){
		while(!deque.isEmpty() && deque.peekLast() < k){
			deque.pollLast();
		}
		deque.offerLast(k);
	}
	public void pop(int k){
		if(!deque.isEmpty() && k==deque.peekFirst()){
			deque.pollFirst();
		}
	}
	public int max(){
		return deque.isEmpty() ? 0 : deque.peekFirst();
	}
}