package labuladong.MaxAreaOfIsland695;

/**
 * You are given an m x n binary matrix grid.
 * An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class Solution {
	int result = 0;
	int tmpResult = 0;
	int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	public int maxAreaOfIsland(int[][] grid) {
		boolean[][] isVisited = new boolean[grid.length][grid[0].length];

		for(int i = 0;i< grid.length;i++){
			for(int j = 0;j<grid[0].length;j++){
				if(!isVisited[i][j] && grid[i][j]==1){
					dfs(grid, isVisited,i,j);
					result = Math.max(result, tmpResult);
					tmpResult = 0;
				}
			}
		}
		return result;
	}

	public void dfs(int[][] grid, boolean[][] isVisited, int i, int j){
		if(i<0 || i >= grid.length || j < 0 || j >= grid[0].length){
			return;
		}

		if(isVisited[i][j]){
			return;
		}

		if(grid[i][j]==0){
			return;
		}
		isVisited[i][j] = true;
		tmpResult++;
		for(int k = 0;k< dirs.length;k++){
			int nexti = i + dirs[k][0];
			int nextj = j+ dirs[k][1];
			dfs(grid, isVisited, nexti,nextj);
		}
	}

}
