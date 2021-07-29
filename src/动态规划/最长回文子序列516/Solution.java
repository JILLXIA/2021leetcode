package 动态规划.最长回文子序列516;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，
 * 删除某些字符或者不删除任何字符形成的一个序列。
 */

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/zi-xu-lie-wen-ti-tong-yong-si-lu-zui-chang-hui-wen/
 * 把这个二维的图画出来就很好理解
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] sarray = s.toCharArray();
        int[][] dp = new int[sarray.length][sarray.length];

        for(int i = 0;i<dp.length;i++){
            dp[i][i] = 1;
        }

        for(int i = dp.length-2;i>=0;i--){
            for(int j = i+1;j<dp.length;j++){
                if(sarray[i]==sarray[j]){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        return dp[0][sarray.length-1];
    }
}
