package labuladong.MinimumWindowSubstring76;

import java.util.HashMap;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character
 * in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 */
public class Solution {
	public String minWindow(String s, String t) {
		HashMap<Character,Integer> need = new HashMap<>();
		HashMap<Character,Integer> window = new HashMap<>();

		for(int i = 0;i<t.length();i++){
			need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
		}

		int left = 0;
		int right = 0;

		int valid = 0;
		int start = 0;
		int len = Integer.MAX_VALUE;
		while(right < s.length()){
			char rightc = s.charAt(right);
			right++;
			if(need.containsKey(rightc)){
				window.put(rightc,window.getOrDefault(rightc,0)+1);
				if(window.get(rightc).equals(need.get(rightc))){
					valid++; // 是否每个字母都用到了
				}
			}

			while(left < s.length() && valid==need.size()){
				if(right - left < len){
					// 记录当前最小长度
					start = left;
					len = right - left;
				}
				char leftc = s.charAt(left);
				left++;
				if(need.containsKey(leftc)){
					if(window.get(leftc).equals(need.get(leftc))) {
						valid--;
					}
					window.put(leftc,window.get(leftc)-1);
				}
			}
		}
		return len==Integer.MAX_VALUE ? "" : s.substring(start,start+len);
	}
}
