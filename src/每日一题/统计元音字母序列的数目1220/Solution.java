package 每日一题.统计元音字母序列的数目1220;

/**
 * 给你一个整数n，请你帮忙统计一下我们可以按下述规则形成多少个长度为n的字符串：
 *
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音'a'后面都只能跟着'e'
 * 每个元音'e'后面只能跟着'a'或者是'i'
 * 每个元音'i'后面不能 再跟着另一个'i'
 * 每个元音'o'后面只能跟着'i'或者是'u'
 * 每个元音'u'后面只能跟着'a'
 * 由于答案可能会很大，所以请你返回 模10^9 + 7之后的结果。
 */
public class Solution {
    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[][] dp = new long[5][n+1]; // 以某个字符结尾 长度为n的字符串

        for(int i = 0;i<5;i++){
            dp[i][1] = 1;
        }

        for(int i = 2;i<=n;i++){
            dp[0][i] = (dp[1][i-1] + dp[2][i-1] + dp[4][i-1])% mod;
            dp[1][i] = (dp[0][i-1] + dp[2][i-1])% mod;
            dp[2][i] = (dp[1][i-1] + dp[3][i-1])% mod;
            dp[3][i] = dp[2][i-1]% mod;
            dp[4][i] = (dp[2][i-1] + dp[3][i-1])% mod;
        }

        long result = 0;
        for(int i = 0;i<5;i++){
            result =(result+ dp[i][n])% mod;
        }
        return (int)result;
    }
}
