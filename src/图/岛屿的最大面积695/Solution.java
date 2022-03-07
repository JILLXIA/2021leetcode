package 图.岛屿的最大面积695;
/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
你可以假设 grid 的四个边缘都被 0（代表水）包围着。

岛屿的面积是岛上值为 1 的单元格的数目。

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class Solution {
    int result = 0;
    int answer = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(!isVisited[i][j] && grid[i][j] == 1){
                    // 如果没有访问过，并且是1
                    dfsIsland(grid,isVisited,i,j);
                    answer = Math.max(answer,result);
                    result = 0;
                }
            }
        }
        return answer;
    }
    
    public void dfsIsland(int[][] grid, boolean[][] isVisited,int i,int j) {
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||isVisited[i][j]|| grid[i][j] == 0){
            // 越界或者已经访问过的节点直接返回
            return ;
        }
        result++;
        isVisited[i][j] = true; // 节点标记为已经访问过的
        dfsIsland(grid,isVisited,i-1,j);
        dfsIsland(grid,isVisited,i+1,j);
        dfsIsland(grid,isVisited,i,j+1);
        dfsIsland(grid,isVisited,i,j-1);
    }
}
