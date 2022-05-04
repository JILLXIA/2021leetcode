package labuladong.PermutationInString567;

import java.util.HashMap;

/**
 * Given two strings s1 and s2, return true if s2 contains
 * a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations
 * is the substring of s2.
 */

public class Solution {
	public boolean checkInclusion(String s1, String s2) {
		HashMap<Character,Integer> need = new HashMap<>();
		HashMap<Character,Integer> window = new HashMap<>();

		for(int i = 0;i<s1.length();i++){
			need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i),0)+1);
		}
		int valid = 0;
		int left = 0;
		int right = 0;
		boolean result = false;

		while(right < s2.length()){
			char rightc = s2.charAt(right);
			right++;
			if(need.containsKey(rightc)){
				window.put(rightc,window.getOrDefault(rightc,0)+1);
				if(window.get(rightc).equals(need.get(rightc))){
					valid++; // 是否每个字母都用到了
				}
			}

			// 什么时候窗口缩小？
			while(right - left >= s1.length()){
				if(right-left==s1.length() && valid==need.size()){
					return true;
				}
				char leftc = s2.charAt(left);
				left++;
				if(need.containsKey(leftc)){
					if(window.get(leftc).equals(need.get(leftc))){
						valid--; // 是否每个字母都用到了
					}
					window.put(leftc,window.getOrDefault(leftc,0)-1);
				}
			}

		}
		return false;
	}
}
