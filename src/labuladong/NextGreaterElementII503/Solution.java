package labuladong.NextGreaterElementII503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, return -1 for this number.
 */
public class Solution {
	public int[] nextGreaterElements(int[] nums) {
		int[] numsConcat = new int[nums.length*2];
		for(int i = 0;i<nums.length;i++){
			numsConcat[i] = nums[i];
			numsConcat[i+ nums.length] = nums[i];
		}
		int[] result = new int[numsConcat.length];
		Deque<Integer> deque = new LinkedList<>();

		for(int i = numsConcat.length-1;i>=0;i--){
			while(!deque.isEmpty() && deque.peekLast() <= numsConcat[i]){
				deque.pollLast();
			}
			result[i] = deque.isEmpty() ? -1 : deque.peekLast();
			deque.offerLast(numsConcat[i]);
		}
		// 获取result的子数组
		return Arrays.copyOfRange(result,0,nums.length);
	}
}
