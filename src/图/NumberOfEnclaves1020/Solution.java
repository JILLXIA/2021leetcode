package 图.NumberOfEnclaves1020;

/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 *
 * A move consists of walking from one land cell to
 * another adjacent (4-directionally) land cell or walking off
 * the boundary of the grid.
 *
 * Return the number of land cells in grid for
 * which we cannot walk off the boundary of the grid in any number of moves.
 */
public class Solution {
    int result = 0;
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numEnclaves(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(i * j * (i-grid.length+1) * (j-grid[0].length+1)==0 && grid[i][j]==1){
                    // tansfer the land cell near the edge to sea cell
                    dfs(grid,i,j);
                }
            }
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                // directly count the number,no need to use dfs again
                if(grid[i][j]==1){
                    result++;
                }
            }
        }
        return result;

    }
    public void dfs(int[][] grid,int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return;
        }
        grid[i][j] = 0;
        for(int k = 0;k< dirs.length;k++){
            dfs(grid,i+dirs[k][0],j+dirs[k][1]);
        }

    }
}
