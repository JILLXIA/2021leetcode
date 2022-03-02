package 动态规划.动态规划21天初级.第N天.编辑距离72;

/**
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */

/**
 * dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
 *
 * 所以，
 *
 * 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
 *
 * 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1],
 * dp[i-1][j], dp[i][j-1]) + 1
 *
 * 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int length1 = word1.length()+1;
        int length2 = word2.length()+1;
        int[][] dp = new int[length1][length2];
        // 需要初始化第一行第一列
        for(int i = 1;i<length1;i++){
            dp[i][0] = dp[i-1][0] + 1;
        }
        for(int i = 1;i<length2;i++){
            dp[0][i] = dp[0][i-1] + 1;
        }
        for(int i = 1;i<length1;i++){
            for(int j = 1;j<length2;j++){
                if(c1[i-1]==c2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
            }
        }
        return dp[length1-1][length2-1];
    }
}
