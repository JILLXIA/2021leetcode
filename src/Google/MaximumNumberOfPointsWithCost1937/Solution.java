package Google.MaximumNumberOfPointsWithCost1937;

/**
 * You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of points you can get from the matrix.
 *
 * To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
 *
 * However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
 *
 * Return the maximum number of points you can achieve.
 */
public class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[] dp = new long[m];
        for(int i = 0;i<m;i++){
            dp[i] = (long)points[0][i];
        }

        for(int i = 1;i < n;i++){
            long[] tmpDp = new long[m];
            long rollMax = -1000000;
            for(int j = 0;j<m;j++){
                rollMax = Math.max(rollMax, dp[j] + j);
                tmpDp[j] = Math.max(rollMax + points[i][j] - j,tmpDp[j]);
            }

            rollMax = -1000000;
            for(int j = m-1;j>=0;j--){
                rollMax = Math.max(rollMax, dp[j]-j);
                tmpDp[j] = Math.max(rollMax + points[i][j] + j,tmpDp[j]);
            }
            dp = tmpDp;
        }
        long result = 0;
        for(int i = 0;i<m;i++){
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
