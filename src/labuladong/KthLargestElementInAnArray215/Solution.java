package labuladong.KthLargestElementInAnArray215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0;i<nums.length;i++){
			if(pq.size()<k) {
				pq.add(nums[i]);
			} else {
				if(nums[i] <= pq.peek()){
					continue;
				}
				pq.poll();
				pq.add(nums[i]);
			}
		}
		return pq.peek();
	}
}
