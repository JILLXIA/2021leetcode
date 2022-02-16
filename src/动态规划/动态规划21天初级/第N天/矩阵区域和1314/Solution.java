package 动态规划.动态规划21天初级.第N天.矩阵区域和1314;
/**
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，
 * 请你返回一个矩阵 answer ，其中每个 answer[i][j] 
 * 是所有满足下述条件的元素 mat[r][c] 的和： 

i - k <= r <= i + k,
j - k <= c <= j + k 且
(r, c) 在矩阵内。
 */
public class Solution {
    // 遇到求和问题想到前缀和
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] answer = new int[mat.length][mat[0].length];
        int[][] preSum = new int[mat.length+1][mat[0].length+1]; // 计算二维数组的前缀和
        for(int i = 1;i<preSum.length;i++){
            for(int j = 1;j<preSum[0].length;j++){
                preSum[i][j] = preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+mat[i-1][j-1];
            }
        }
        for(int i = 0;i<answer.length;i++){
            for(int j = 0;j<answer[0].length;j++){
                int startx = j - k <= 0 ? 0 : j - k;
                int endx = j + k >= answer[0].length ? answer[0].length - 1: j + k;
                int starty = i - k <= 0 ? 0 : i - k;
                int endy = i + k >= answer.length ? answer.length - 1: i + k;
                answer[i][j] = preSum[endy+1][endx+1] - preSum[endy+1][startx] - preSum[starty][endx+1] + preSum[starty][startx];
            }
        }
        return answer;
    }
}
