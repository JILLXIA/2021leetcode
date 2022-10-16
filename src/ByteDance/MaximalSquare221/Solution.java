package ByteDance.MaximalSquare221;

/**
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and
 * return its area.
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int[] dp = new int[matrix[0].length+1];
        int result = 0;
        int prev = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                int tmp = dp[j+1];
                if(matrix[i][j] == '1'){
                    dp[j+1] = Math.min(dp[j], Math.min(dp[j+1], prev)) + 1;
                    result = Math.max(result, dp[j+1]);
                } else {
                    // 变成一尾dp的时候需要归零
                    dp[j+1] = 0;
                }
                prev = tmp;

            }
        }
        return result * result;
    }
}
