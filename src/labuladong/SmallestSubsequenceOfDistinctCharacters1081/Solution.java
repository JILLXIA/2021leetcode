package labuladong.SmallestSubsequenceOfDistinctCharacters1081;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s, return the lexicographically smallest
 * subsequence of s that contains all the distinct characters of
 * s exactly once.
 */
public class Solution {
	public String smallestSubsequence(String s) {
		int[] count = new int[26];
		boolean[] isConsist = new boolean[26];
		Deque<Character> deque = new LinkedList<>();
		for(int i = 0;i<s.length();i++){
			count[s.charAt(i)-'a']++;
		}

		for(int i = 0;i<s.length();i++){
			int c = s.charAt(i)-'a';
			count[c]--;
			if(isConsist[c]){
				continue;
			}
			while(!deque.isEmpty() && deque.peekLast() > s.charAt(i)){
				if(count[deque.peekLast()-'a']>0){
					isConsist[deque.pollLast()-'a'] = false;
				}else {
					break;
				}
			}
			deque.offerLast(s.charAt(i));
			isConsist[c] = true;
		}

		StringBuilder sb = new StringBuilder();
		while(!deque.isEmpty()){
			sb.append(deque.pollFirst());
		}
		return sb.toString();
	}
}
