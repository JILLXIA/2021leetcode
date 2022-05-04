package labuladong.FindAllAnagramsInAString438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two strings s and p, return an array of
 * all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the
 * original letters exactly once.
 */
public class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		HashMap<Character,Integer> need = new HashMap<>();
		HashMap<Character,Integer> window = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		for(int i = 0;i<p.length();i++){
			need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);
		}

		int valid = 0;
		int left = 0;
		int right = 0;
		while(right < s.length()){
			char rightc = s.charAt(right);
			right++;
			if(need.containsKey(rightc)){
				window.put(rightc,window.getOrDefault(rightc,0)+1);
				if(window.get(rightc).equals(need.get(rightc))){
					valid++;
				}
			}
			while(right-left >= p.length()){
				if(valid==need.size() && right-left==p.length()){
					result.add(left);
				}
				char leftc = s.charAt(left);
				left++;
				if(need.containsKey(leftc)){
					if(window.get(leftc).equals(need.get(leftc))){
						valid--;
					}
					window.put(leftc,window.getOrDefault(leftc,0)-1);
				}
			}
		}
		return result;
	}
}
