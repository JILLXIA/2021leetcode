package labuladong.DeleteOperationForTwoStrings583;

import java.util.Arrays;

/**
 * Given two strings word1 and word2,
 * return the minimum number of steps required to
 * make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 */
public class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return dp(word1,m-1,word2,n-1);
    }

    public int dp(String word1, int m, String word2, int n){
        if(m<0 || n<0){
            return Math.max(m,n)+1;
        }
        if(memo[m][n]!=-1){
            return memo[m][n];
        }
        if(word1.charAt(m)==word2.charAt(n)){
            return dp(word1,m-1,word2,n-1);
        }

        int tmp1 = dp(word1,m-1,word2,n) + 1;
        int tmp2 = dp(word1,m,word2,n-1) + 1;
        memo[m][n] = Math.min(tmp1,tmp2);
        return memo[m][n];
    }
}
