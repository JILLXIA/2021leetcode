package 动态规划.动态规划21天初级.第N天.最大正方形221;

public class Solution1 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        // dp 表示右下为正方形的最大边长
        int side = 0;
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + 1;
                    side = Math.max(side,dp[i][j]);
                }
            }
        }
        return side * side;
    }
}
