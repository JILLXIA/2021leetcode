package labuladong.RemoveDuplicateLetters316;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s,
 * remove duplicate letters so that every letter appears once
 * and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 */
public class Solution {
	public String removeDuplicateLetters(String s) {
		// 1. remove duplicate letters
		// 2. 保持原来顺序
		// 3. 字典序最小
		boolean[] isConsist = new boolean[26];
		int[] count = new int[26];
		for(int i = 0;i<s.length();i++){
			count[s.charAt(i)-'a']++;
		}
		Deque<Character> deque = new LinkedList<>();
		for(int i = 0;i<s.length();i++){
			count[s.charAt(i)-'a']--;
			if(!isConsist[s.charAt(i)-'a']){
				while(!deque.isEmpty() && deque.peekLast() > s.charAt(i)){
					if(count[deque.peekLast()-'a']>0){
						isConsist[deque.pollLast()-'a'] = false;
					} else {
						break;
					}
				}
				deque.offerLast(s.charAt(i));
				isConsist[s.charAt(i)-'a'] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!deque.isEmpty()){
			sb.append(deque.pollFirst());
		}
		return sb.toString();
	}
}
