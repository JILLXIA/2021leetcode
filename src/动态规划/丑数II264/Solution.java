package 动态规划.丑数II264;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        //三个指针，分别指向该乘2，3，5的下标，先排再存

        for(int i = 1;i<n;i++){
            dp[i] = Math.min(dp[index2]*2,Math.min(dp[index3]*3,dp[index5]*5));
            if(dp[i]==dp[index2]*2){
                index2++;
            }//这里把三个if分开写，为了去掉相等重复的情况
            if(dp[i]==dp[index3]*3){
                index3++;
            }
            if(dp[i]==dp[index5]*5){
                index5++;
            }
        }

        return dp[n-1];
    }
    public static void main(String[] args){
        Solution s = new Solution();
        s.nthUglyNumber(10);
    }
}
