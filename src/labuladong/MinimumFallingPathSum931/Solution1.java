package labuladong.MinimumFallingPathSum931;

class Solution1 {
	public int minFallingPathSum(int[][] matrix) {
		int[] dp = new int[matrix.length];

		int n = matrix.length;
		for(int i = 0;i<n;i++){
			dp[i] = matrix[0][i];
		}

		for(int i = 1;i<n;i++){
			int[] tmp = new int[n];
			for(int j = 0;j<n;j++){
				int tmp1 = Integer.MAX_VALUE;
				int tmp2 = Integer.MAX_VALUE;
				int tmp3 = Integer.MAX_VALUE;
				if(j>0){
					tmp1 = dp[j-1];
				}
				tmp2 = dp[j];
				if(j<n-1){
					tmp3 = dp[j+1];
				}
				tmp[j] = Math.min(tmp1,Math.min(tmp2,tmp3))+matrix[i][j];
			}
			dp = tmp;
		}
		int result = Integer.MAX_VALUE;
		for(int k = 0;k<n;k++){
			result = Math.min(result,dp[k]);
		}
		return result;
	}
}