package 动态规划.动态规划21天初级.第N天.最长回文字串5;
/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Solution {
    // s转化为char数组索引比较快！！！！
    // 因为是子字符串，知道开头的char和长度就可以推算出结尾的字符串
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s; // 边界情况
        }
        boolean[][] dp = new boolean[s.length()][s.length()]; //  i - j 的串是否是回文串
        int maxLength = s.length();
        // 初始值，单个子串都是true
        for(int i = 0;i<dp.length;i++){
            dp[i][i] = true;
        }
        int begin = 0;
        int maxL = 1;
        char[] cArr = s.toCharArray();
        for(int L = 2;L<=maxLength;L++){
            // 枚举长度
            for(int i = 0;i<dp.length;i++){
                // 枚举起点i
                int j = i + L - 1; // 终点j
                // 如果 j 越界，继续执行下一个循环
                if(j>=dp.length){
                    continue;
                }
                // 如果长度只有2的特殊情况
                if(L==2){
                    dp[i][j] = cArr[i] == cArr[j];
                } else{
                    dp[i][j] = dp[i+1][j-1] && cArr[i] == cArr[j];
                }
                if(dp[i][j] && L>maxL){
                    maxL = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxL);
    }
    
}
