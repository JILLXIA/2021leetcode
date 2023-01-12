package ProgrammerCarl.SpiralMatrix54;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix,
 * return all elements of the matrix in spiral order.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int down = matrix.length-1;

        int left = 0;
        int right = matrix[0].length-1;

        List<Integer> result = new ArrayList<>();
        while(top <= down && left <= right){
            for(int i = left; i<= right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            for(int i = top;i<=down;i++){
                result.add(matrix[i][right]);
            }
            right--;

            if(top <= down){
                for(int i = right;i>=left;i--){
                    result.add(matrix[down][i]);
                }
                down--;
            }

            if(left <= right){
                for(int i = down;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
