package labuladong.DaliyTemperatures739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of
 * days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		Deque<int[]> deque = new LinkedList<>();

		for(int i = temperatures.length-1; i >= 0;i--){
			while(!deque.isEmpty() && deque.peekLast()[0] <= temperatures[i]){
				deque.pollLast();
			}
			result[i] = deque.isEmpty() ? 0 : (deque.peekLast()[1]-i);
			deque.offerLast(new int[]{temperatures[i],i});
		}
		return result;
	}
}
