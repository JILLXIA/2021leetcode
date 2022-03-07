package 图.NumberOfClosedIslands1254;
/**
 * Given a 2D grid consists of 0s (land) and 1s (water). 
 *  An island is a maximal 4-directionally connected group of 0s 
 * and a closed island is an island totally 
 * (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.
 */
public class Solution {
    // Time & space: O(m * n), where m = grid.length, n = grid[0].length.
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int closedIsland(int[][] grid) {
        // remove the land next to the edge
        int length1 = grid.length;
        int length2 = grid[0].length;
        int result = 0;
        for(int i = 0;i<length1;i++){
            for(int j = 0;j<length2;j++){
                if(i * j * (i-length1+1) * (j-length2+1)==0){
                    dfs(grid,i,j);
                }
            }
        }

        for(int i = 0;i<length1;i++){
            for(int j = 0;j<length2;j++){
                if(grid[i][j]==0){
                    dfs(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int[][] grid,int i, int j){
        // when the land cell exceed the boundary or is water; we need to return
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==1){
            return;
        }

        grid[i][j] = 1;
        for(int k = 0;k<dirs.length;k++){
            dfs(grid,i+dirs[k][0],j+dirs[k][1]); // traverse 4 neighbour of (i,j)
        }
    }
    
}
