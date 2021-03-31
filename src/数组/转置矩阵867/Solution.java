package 数组.转置矩阵867;

/**
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 1. 不一定是n*n的矩阵
 */
public class Solution {
    public int[][] transpose(int[][] matrix) {
        int length1 = matrix.length;
        int length2 = matrix[0].length;
        int[][] matrix_result = new int[length2][length1];

        for(int i = 0;i<length1;i++) {
            for (int j = 0; j < length2; j++) {
                matrix_result[j][i] = matrix[i][j];
            }
        }
        return matrix_result;
    }
}
