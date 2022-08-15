package labuladong.MinimumFallingPathSum931;

import java.util.Arrays;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class Solution {
	// use dfs, we need to set up a 2 dimension matrix. Can we use Bfs?
	int[][] memo;
	public int minFallingPathSum(int[][] matrix) {
		memo = new int[matrix.length][matrix.length];
		for(int i = 0;i< matrix.length;i++){
			Arrays.fill(memo[i],101);
		}
		int result = Integer.MAX_VALUE;
		for(int i = 0;i< matrix.length;i++){
			result = Math.min(result,dp(matrix, matrix.length-1,i));
		}
		return result;
	}

	public int dp(int[][] matrix, int line, int index){
		if(line<0 || line >= matrix.length || index < 0|| index >= matrix.length){
			return Integer.MAX_VALUE;
		}



		if(line==0){
			// achieve the last row
			return matrix[line][index];
		}

		if(memo[line][index]!=101){
			return memo[line][index];
		}
		int result = Integer.MAX_VALUE;


		int tmp1 = dp(matrix,line-1,index);
		int tmp2 = dp(matrix,line-1,index+1);
		int tmp3 = dp(matrix,line-1,index-1);
		result = Math.min(result,
				matrix[line][index]+Math.min(tmp1,Math.min(tmp2,tmp3)));
		memo[line][index] = result;
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
	}
}
