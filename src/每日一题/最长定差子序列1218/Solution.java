package 每日一题.最长定差子序列1218;

import java.util.HashMap;

/**
 * 给你一个整数数组arr和一个整数difference，
 * 请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 *
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 */
public class Solution {
	public int longestSubsequence(int[] arr, int difference) {
		// 一看可以用动态规划的方法做
		// 难点在于找到arr[i] - difference 的index
		// 如果用HashMap来存储，就可以不用关注index
		// 如果数组里面两个数一样的，那么较大的dp一定比较大，所以其实不用存储较小的dp
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int result = 0;
		for(int tmp: arr){
			map.put(tmp,map.getOrDefault(tmp - difference,0)+1);
			result = Math.max(result,map.get(tmp));
		}
		return result;
	}
}
