package labuladong.NumberOfDistinctIsland694;

import java.util.HashSet;

/**
 * You are given an m x n binary matrix grid.
 * An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * An island is considered to be the same as another if
 * and only if one island can be translated (and not rotated or reflected)
 * to equal the other.
 *
 * Return the number of distinct islands.
 */
public class Solution {
	int result = 0;
	HashSet<String> set = new HashSet<>();
	StringBuilder path = new StringBuilder();
	public int numDistinctIslands(int[][] grid) {
		// the same island => the same visited order
		// 1-》up  -1 recall up
		// 2-> down -2 recall down
		// 3=> left  -3 recall left
		// 4 -> right -4 recall right

		for(int i = 0;i<grid.length;i++){
			for(int j = 0;j<grid[0].length;j++){
				if(grid[i][j]==1){
					dfs(grid,i,j,0);
					set.add(path.toString());
					path = new StringBuilder();
				}
			}
		}
		return set.size();
	}

	public void dfs(int[][] grid, int i, int j, int dir){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
			return ;
		}

		if(grid[i][j]==0){
			return;
		}
		grid[i][j]=0;
		path.append(dir).append(',');
		dfs(grid,i+1,j,1);
		dfs(grid,i-1,j,2);
		dfs(grid, i, j+1,3);
		dfs(grid,i,j-1,4);
		path.append(-dir).append(',');
	}
}
