package 动态规划.一和零474;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，
 * 该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];

        for(int i = 1;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                for(int k = 0;k<dp[0][0].length;k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    int count0 = count(strs[i-1],'0');
                    int count1 = count(strs[i-1],'1');
                    if(j >= count0 && k>=count1){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j-count0][k-count1]+1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
    public int count(String str, char c){
        char[] arr = str.toCharArray();
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            if(str.charAt(i) == c){
                sum++;
            }
        }
        return sum;
    }
}
