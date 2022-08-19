package labuladong.EditDistance72;

import java.util.Arrays;

/**
 * Given two strings word1 and word2,
 * return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class Solution {
	int[][] memo;
	public int minDistance(String word1, String word2) {
		// use two index point to the end of the two string
		int m = word1.length();
		int n = word2.length();
		memo = new int[m][n];
		for(int i = 0;i<m;i++){
			Arrays.fill(memo[i],-1);
		}
		return dp(word1,m-1,word2,n-1);
	}

	public int dp(String word1, int m, String word2, int n){
		if(m==-1){
			return n+1;
		}

		if(n==-1){
			return m+1;
		}
		if(memo[m][n]!=-1){
			return memo[m][n];
		}
		if(word1.charAt(m)==word2.charAt(n)){
			return dp(word1,m-1,word2,n-1);
		}

		int tmp1 = dp(word1,m-1,word2,n)+1;
		int tmp2 = dp(word1,m,word2,n-1)+1;
		int tmp3 = dp(word1, m-1, word2,n-1)+1;
		int result = Math.min(tmp1,Math.min(tmp2,tmp3));
		memo[m][n] = result;
		return result;
	}

}
