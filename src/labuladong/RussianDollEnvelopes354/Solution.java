package labuladong.RussianDollEnvelopes354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * Note: You cannot rotate an envelope.
 */
public class Solution {
	public int maxEnvelopes(int[][] envelopes) {
		// 二维版本的最长子序列问题，最值问题可以想到动态规划
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]){
					return o2[1]-o1[1];
				}
				return o1[0]-o2[0];
			}
		});
		int[] height = new int[envelopes.length];
		for(int i = 0;i<envelopes.length;i++){
			height[i] = envelopes[i][1];
		}
		return findLongestSubString(height);
	}
// longest substring问题是严格递增的，所以需要找leftmost， 如果相等也可以，那么应该找rightmost+1
	public int findLongestSubString(int[] arr){
		int[] top = new int[arr.length];
		int piles = 0;
		for(int i = 0;i<arr.length;i++){
			int left = 0;
			int right = piles;
			int poket = arr[i];
			while(left < right){
				int mid = left + (right - left) / 2;
				if(top[mid] >= poket){
					right = mid;
				} else {
					left = mid+1;
				}
			}
			if(left==piles){
				piles++;
			}
			top[left] = poket;
		}
		return piles;
	}
}
