package labuladong.NextGreaterElementI496;

import java.util.Deque;
import java.util.LinkedList;

/**
 * The next greater element of some element x in an array is the
 * first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2,
 * where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that
 * nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i]
 * is the next greater element as described above.
 */
public class Solution {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		int[] map = new int[10000];
		Deque<Integer> deque = new LinkedList<>();
		for(int i = nums2.length-1;i >= 0;i--){
			while(!deque.isEmpty() && deque.peekLast() < nums2[i]){
				deque.pollLast();
			}
			map[nums2[i]] = deque.isEmpty() ? -1 : deque.peekLast();
			deque.offerLast(nums2[i]);
		}

		for(int i = 0;i<result.length;i++){
			result[i] = map[nums1[i]];
		}
		return result;
	}
}
