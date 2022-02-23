package 动态规划.动态规划21天初级.第N天.最大正方形221;
/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Solution {
    // 动态规划的变量找错啦，找成面积啦，应该找边长。
    public int[][] preSum;
    public int maximalSquare(char[][] matrix) {
        preSum = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 1;i<preSum.length;i++){
            for(int j = 1;j<preSum[0].length;j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + (matrix[i-1][j-1] - '0');
            }
        }
        int result = 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1]; // 以当前点为右下点的正方形最大面积
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(matrix[i-1][j-1] == '0'){
                    continue;
                }
                int preLength = dp[i-1][j-1] > 0 ? (int)Math.sqrt((double)(dp[i-1][j-1])) : 0;
                if(preLength == 0){
                    dp[i][j] = 1;
                    continue;
                }
                boolean tmp = false;
                while((tmp || dp[i][j]!=0) && isSquare(i-preLength,j-preLength, i, j)) {
                    tmp =true;
                    dp[i][j] = (preLength + 1) * (preLength + 1);
                    result = Math.max(result,dp[i][j]);
                    preLength--;
                }
            }
        }
        return result;

    }

    public boolean isSquare(int x1,int y1,int x2,int y2) {
        int count = preSum[x2][y2] - preSum[x1-1][y2] - preSum[x2][y1-1] + preSum[x1-1][y1-1];
        return count == (x2-x1+1) * (y2 - y1+1);
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.maximalSquare(new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}}));
    }
}
