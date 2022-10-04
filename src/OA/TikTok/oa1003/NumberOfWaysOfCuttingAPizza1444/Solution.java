package OA.TikTok.oa1003.NumberOfWaysOfCuttingAPizza1444;

import java.util.Arrays;

public class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();

        int[][] prefixSum = new int[m+1][n+1];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                prefixSum[i+1][j+1] = prefixSum[i+1][j] + prefixSum[i][j+1] + ((pizza[i].charAt(j)=='A') ? 1:0) - prefixSum[i][j];
            }
        }
        int[][][] dp = new int[m][n][k];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return dfs(0,m,0,n,k-1,prefixSum,dp);
    }

    public int hasApple(int x1, int y1, int x2, int y2, int[][] prefixSum){
        return prefixSum[y2+1][x2+1] - prefixSum[y2+1][x1] - prefixSum[y1][x2+1] + prefixSum[y1][x1] > 0 ? 1 : 0;
    }
    public int dfs(int m, int M, int n, int N, int k, int[][] prefixSum, int[][][] dp){
        if(k == 0){
            return hasApple(n,m,N-1,M-1,prefixSum);
        }
        if(dp[m][n][k] != -1){
            return dp[m][n][k];
        }
        dp[m][n][k] = 0;
        for(int i = m;i<M-1;i++){
            dp[m][n][k] = (dp[m][n][k] + hasApple(n,m,N-1,i,prefixSum) * dfs(i+1,M,n,N,k-1,prefixSum,dp)) % 1000000007;
        }

        for(int j = n;j<N-1;j++){
            dp[m][n][k] = (dp[m][n][k] + hasApple(n,m,j,M-1,prefixSum) * dfs(m,M,j+1,N,k-1,prefixSum,dp))% 1000000007;
        }
        return dp[m][n][k];
    }
}
