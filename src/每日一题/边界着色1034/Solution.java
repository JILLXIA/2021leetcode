package 每日一题.边界着色1034;

/**
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。
 * 另给你三个整数row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *
 * 两个网格块属于同一 连通分量 需满足下述全部条件：
 *
 * 两个网格块颜色相同
 * 在上、下、左、右任意一个方向上相邻
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 *
 * 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 请你使用指定颜色color 为所有包含网格块grid[row][col] 的 连通分量的边界 进行着色，
 * 并返回最终的网格grid 。
 */
public class Solution {
    int[][] _grid;
    int[][] result;
    int _color;
    int targetColor;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        _grid = grid;
        int[][] isVisited = new int[grid.length][grid[0].length];
        targetColor = grid[row][col];
        result = new int[grid.length][grid[0].length];
        for(int i = 0;i<result.length;i++){
            result[i] = grid[i].clone(); // 二维数组深拷贝
        }
        _color = color;
        dfs(row,col,isVisited);
        return result;
    }

    public void dfs(int row,int col,int[][] isVisited) {
        if(row>=_grid.length || col>=_grid[0].length || row<0 || col<0  || _grid[row][col]!= targetColor||isVisited[row][col]==1){
            return;
        }
        boolean[] tmp = new boolean[4];
        // 先判断当前这个是不是再向外扩张
        for(int i = 0;i<dirs.length;i++){
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            tmp[i] = newRow>=_grid.length || newCol>=_grid[0].length || newRow<0 || newCol<0  || _grid[newRow][newCol]!= targetColor;
        }
        if(tmp[0] || tmp[1] || tmp[2] || tmp[3]) {
            result[row][col] = _color;
        }
        isVisited[row][col] = 1;
        dfs( row + 1, col, isVisited);
        dfs( row - 1, col, isVisited);
        dfs( row , col+1, isVisited);
        dfs( row , col-1, isVisited);
        return ;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        s.colorBorder(new int[][]{{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}},1,3,1);
    }
}
