package labuladong.LongestSubstringWithoutRepeatingCharacters3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string s,
 * find the length of the longest substring without repeating characters.
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> window = new HashMap<>();
		int left = 0;
		int right = 0;
		int result = 0;
		boolean check = true;
		// 检查是否有重复的字母可以用数组判定
		// 用map反而更复杂了。
		while(right<s.length()){
			char rightc = s.charAt(right);
			right++;
			if(window.containsKey(rightc)) {
				check = false;
				window.put(rightc, window.getOrDefault(rightc, 0) + 1);
			} else {
				window.put(rightc, window.getOrDefault(rightc, 0) + 1);
				result = Math.max(result,window.size());

			}
			while(!check && left <= right){
				char leftc = s.charAt(left);
				left++;
				if(window.get(leftc) != null && window.get(leftc) > 1){
					check = true;
					window.put(leftc, window.getOrDefault(leftc, 0) - 1);
				}else{
					window.remove(leftc);
				}

			}
		}
		return result;
	}
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring("pwwkew"));
	}
}
