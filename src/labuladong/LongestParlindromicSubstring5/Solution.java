package labuladong.LongestParlindromicSubstring5;

import java.util.Arrays;

/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class Solution {
	public String longestPalindrome(String s) {
		//O(n^2)
		int[] arr = new int[s.length()];
		Arrays.fill(arr,1);
		String result = s.substring(0,1); // 注意长度为1的，不进入下面的循环
		for(int i = 1;i<s.length();i++){
			String findPara1 = find(i-1,i,s);
			String findPara2 = find(i,i,s);
			if(findPara1.length()>result.length()){
				result = findPara1;
			}
			if(findPara2.length()>result.length()){
				result = findPara2;
			}
		}
		return result;
	}
	public String find(int left,int right, String s){
		while(left>=0 && right < s.length()){
			if(s.charAt(left) == s.charAt(right)){
				left--;
				right++;
			} else {
				break;
			}
		}
		return s.substring(left+1,right);
	}
}
