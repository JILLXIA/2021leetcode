package ProgrammerCarl.SpiralMatrixII59;

/**
 * Given a positive integer n,
 * generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;

        int curr = 1;

        // 停止的条件是 up <= down && left <= right
        while(up <= down && left <= right){
            for(int i = left; i <= right;i++){
                result[up][i] = curr;
                curr++;
            }
            up++;

            for(int i = up;i <= down;i++){
                result[i][right] = curr;
                curr++;
            }
            right--;

            for(int i = right;i>=left;i--){
                result[down][i] = curr;
                curr++;
            }
            down--;

            for(int i = down; i >= up;i--){
                result[i][left] = curr;
                curr++;
            }
            left++;
        }
        return result;
    }
}
