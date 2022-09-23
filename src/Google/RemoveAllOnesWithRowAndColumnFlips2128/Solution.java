package Google.RemoveAllOnesWithRowAndColumnFlips2128;

/**
 * You are given an m x n binary matrix grid.
 *
 * In one operation,
 * you can choose any row or column and flip each value
 * in that row or column (i.e., changing all 0's to 1's,
 * and all 1's to 0's).
 *
 * Return true if it is possible to remove all 1's
 * from grid using any number of operations or false otherwise.
 */
public class Solution {
    public boolean removeOnes(int[][] grid) {
        for(int i = 0;i<grid[0].length;i++){
            if(grid[0][i]==1){
                flipColumn(grid,i);
            }
        }
        for(int i = 1;i<grid.length;i++){
            for(int j = 1;j<grid[0].length;j++){
                if(grid[i][j]!=grid[i][j-1]){
                    return false;
                }
            }
        }
        return true;
    }

    public void flipColumn(int[][] grid, int index){
        for(int i = 0;i< grid.length;i++){
            grid[i][index] = 1 - grid[i][index];
        }
    }
}
