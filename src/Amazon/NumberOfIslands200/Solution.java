package Amazon.NumberOfIslands200;

/**
 * Given an m x n 2D binary grid grid
 * which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        // dfs the grid, change 1->0, no need to use isVisited
        int result = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(i,j,grid);
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, char[][] grid){
        if(i<0 || i>= grid.length || j < 0 || j >= grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}
