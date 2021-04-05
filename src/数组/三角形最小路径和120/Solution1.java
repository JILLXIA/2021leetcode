package 数组.三角形最小路径和120;

import java.util.List;

/**
 * 官方题解用的是从上到下
 */
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int maxLength = triangle.get(length-1).size();
        int[][] dp = new int[length][maxLength];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i<length;i++){
            for(int j = 0;j<triangle.get(i).size();j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j]+triangle.get(i).get(j);
                }else if(j==triangle.get(i).size()-1){
                    dp[i][j] = dp[i-1][j-1]+triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
                }
            }
        }
        int result = dp[length-1][0];
        for(int i = 1;i<triangle.get(length-1).size();i++){
            result = Math.max(result,dp[length-1][i]);
        }
        return result;
    }
}
