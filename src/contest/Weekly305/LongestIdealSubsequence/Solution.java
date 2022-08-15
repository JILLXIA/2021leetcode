package contest.Weekly305.LongestIdealSubsequence;

import java.util.HashMap;

public class Solution {


    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int result = 1;
        for(int i = 0;i<s.length();i++){
            dp[s.charAt(i)-'a']++;
            for(int j = Math.max(s.charAt(i)-'a'-k,0);j<=Math.min(s.charAt(i)-'a'+k,25);j++){
                if(j!=s.charAt(i)-'a'){
                    dp[s.charAt(i)-'a'] = Math.max(dp[s.charAt(i)-'a'], dp[j]+1);
                }
            }
            result = Math.max(result,dp[s.charAt(i)-'a']);
        }
        return result;

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestIdealString("acfgbd",2));
    }
}
