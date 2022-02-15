package 动态规划.动态规划21天初级.第N天.下降路径最小和;
/**
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
在下一行选择的元素和当前行所选元素最多相隔一列
（即位于正下方或者沿对角线向左或者向右的第一个元素）。
具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、
(row + 1, col) 或者 (row + 1, col + 1) 。
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix[0].length;i++) {
            dp[0][i] = matrix[0][i];
        }
        if(matrix.length==1){
            return dp[0][0];
        }
        int tmp1 = Integer.MAX_VALUE;
        int tmp2 = Integer.MAX_VALUE;
        int tmp3 = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i = 1;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(j!=0){
                    tmp1 = dp[i-1][j-1];
                }
                tmp2 = dp[i-1][j];
                if(j!=matrix[0].length-1){
                    tmp3 = dp[i-1][j+1];
                }
                
                dp[i][j] = Math.min(tmp1,Math.min(tmp2,tmp3)) + matrix[i][j];
                tmp1 = Integer.MAX_VALUE;
                tmp2 = Integer.MAX_VALUE;
                tmp3 = Integer.MAX_VALUE;
                if(i==matrix.length-1){
                    result = Math.min(result,dp[i][j]);
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        s.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}});
    }
}
