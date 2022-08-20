package labuladong.LongestCommonSubsequence1143;

import java.util.Arrays;

/**
 * Given two strings text1 and text2,
 * return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class Solution {
	// Top-Down DP
	int[][] memo;
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		memo = new int[m][n];
		for(int i = 0;i<m;i++){
			Arrays.fill(memo[i],-1);
		}
		return dp(text1,m-1,text2,n-1);
	}

	public int dp(String text1, int m, String text2, int n){
		if(m==-1 || n==-1){
			return 0;
		}

		if(memo[m][n]!=-1){
			return memo[m][n];
		}
		if(text1.charAt(m)==text2.charAt(n)){
			return dp(text1,m-1,text2,n-1)+1;
		}

		int tmp1 = dp(text1,m-1,text2,n);
		int tmp2 = dp(text1,m,text2,n-1);
		int tmp3 = dp(text1,m-1,text2,n-1);
		int result = Math.max(tmp1,Math.max(tmp2,tmp3));
		memo[m][n] = result;
		return result;
	}
}
