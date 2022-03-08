package 图.CountSubIslands1905;

/**
 * You are given two m x n binary matrices grid1 and grid2
 * containing only 0's (representing water) and 1's (representing land).
 * An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 *
 * An island in grid2 is considered a sub-island if there is an
 * island in grid1 that contains all the cells that make up this
 * island in grid2.
 *
 * Return the number of islands in grid2 that are considered sub-islands.
 */
public class Solution {
    boolean check = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;

        for(int i = 0;i<grid2.length;i++){
            for(int j = 0;j<grid2[0].length;j++){
                if(grid2[i][j]==1){
                    dfs(grid1,grid2,i,j);
                    if(check) {
                        result++;
                    }else{
                        check = true;
                    }
                }
            }
        }
        return result;
    }

    public void dfs(int[][] grid1,int[][] grid2, int i, int j) {
        if(i<0||j<0||i>=grid2.length||j>=grid2[0].length||grid2[i][j]==0){
            return;
        }
        if(grid1[i][j] == 0){
            // land cell in grid2 can't match the land cell in grid1
            check = false;
        }

        grid2[i][j] = 0;
        dfs(grid1,grid2,i+1,j);
        dfs(grid1,grid2,i-1,j);
        dfs(grid1,grid2,i,j+1);
        dfs(grid1,grid2,i,j-1);
    }
}
