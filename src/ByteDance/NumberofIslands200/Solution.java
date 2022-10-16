package ByteDance.NumberofIslands200;

public class Solution {
    public int numIslands(char[][] grid) {
        // ["0","1","1","1","0"],
        // ["1","1","0","1","0"],
        // ["1","1","0","0","0"],
        // ["0","0","0","0","0"]
        int result = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){

                if(grid[i][j]=='1'){
                    result++;
                    // dfs
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || i>=grid.length || j < 0 || j >= grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';

        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
