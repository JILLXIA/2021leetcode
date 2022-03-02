package 图.岛屿数量200;
/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。
 */
public class Solution {
    int result = 0;
    public int numIslands(char[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(!isVisited[i][j] && grid[i][j] == '1'){
                    // 如果没有访问过，并且是1
                    dfsIsland(grid,isVisited,i,j);
                    result++;
                }
            }
        }
        return result;
    }
    
    public void dfsIsland(char[][] grid, boolean[][] isVisited,int i,int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||isVisited[i][j]|| grid[i][j] == '0'){
            // 越界或者已经访问过的节点直接返回
            return ;
        }

        isVisited[i][j] = true; // 节点标记为已经访问过的
        dfsIsland(grid,isVisited,i-1,j);
        dfsIsland(grid,isVisited,i+1,j);
        dfsIsland(grid,isVisited,i,j+1);
        dfsIsland(grid,isVisited,i,j-1);
    }
}
