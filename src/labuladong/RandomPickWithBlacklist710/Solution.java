package labuladong.RandomPickWithBlacklist710;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * You are given an integer n and an array of unique integers blacklist. Design an algorithm to pick a random integer in the range [0, n - 1] that is not in blacklist. Any integer that is in the mentioned range and not in blacklist should be equally likely to be returned.
 *
 * Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.
 *
 * Implement the Solution class:
 *
 * Solution(int n, int[] blacklist) Initializes the object with the integer n and the blacklisted integers blacklist.
 * int pick() Returns a random integer in the range [0, n - 1] and not in blacklist.
 */
public class Solution {
	// 想象一个有序的数据结构，前面放的是正常的数值，后面放的是blackList,我们取的时候从前面的正常的数值里面取
	// 需要将blackList中的值跟后面的值做一个映射
	// 一个hashmap就够了，不需要弄一个自增1的数组
	HashMap<Integer,Integer> map;
	Random rd;
	int size;
	public Solution(int n, int[] blacklist) {
		rd = new Random();
		map = new HashMap<>();
		for(int i = 0;i< blacklist.length;i++){
			map.put(blacklist[i],-1);
		}

		int bound = n- blacklist.length;
		this.size = bound;
		int changeIndex = bound;
		for(int i = 0;i<blacklist.length;i++){
			if(blacklist[i] >= bound){
				continue;
			}
			while(map.containsKey(changeIndex)) {
				changeIndex++;
			}
			map.put(blacklist[i],changeIndex);
			changeIndex++;
		}

	}

	public int pick() {
		int rdNum = rd.nextInt(this.size);
		if(map.containsKey(rdNum)){
			return map.get(rdNum);
		}
		return rdNum;
	}
}
