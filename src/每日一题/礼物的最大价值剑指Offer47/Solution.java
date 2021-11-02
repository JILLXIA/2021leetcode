package 每日一题.礼物的最大价值剑指Offer47;

public class Solution {
	/**
	 * 在一个 m*n 的棋盘的每一格都放有一个礼物，
	 * 每个礼物都有一定的价值（价值大于 0）。
	 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
	 * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，
	 * 请计算你最多能拿到多少价值的礼物？
	 */
	public int maxValue(int[][] grid) {
		int[][] dp = new int[grid.length+1][grid[0].length+1];
		for(int i = 1;i<dp.length;i++){
			for(int j = 1;j<dp[0].length;j++){
				dp[i][j] = grid[i-1][j-1] + Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

	public static void main(String[] args){
		int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
		Solution s = new Solution();
		s.maxValue(arr);
	}
}
