package 动态规划.零钱兑换322;

/**
 * 注意设置初始值
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        int[] dp = new int[amount+1];
        dp[0] = -1;

        for(int i = 1;i<dp.length;i++){
            int result = Integer.MAX_VALUE;
            for(int coin:coins){
                if(i==coin){
                    result = 0;
                }else if(!(i-coin<0 || dp[i-coin]==-1)){
                    result = Math.min(result,dp[i-coin]);
                }
            }

            dp[i] = result==Integer.MAX_VALUE?-1:result+1;
        }
        return dp[amount];
    }

    public static void main(String[] args){
        Solution1 s = new Solution1();
        System.out.println(s.coinChange(new int[]{1,2,5},11));
    }
}
