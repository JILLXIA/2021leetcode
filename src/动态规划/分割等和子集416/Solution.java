package 动态规划.分割等和子集416;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        //01背包问题，某一个数装还是不装
        boolean[][] dp = new boolean[nums.length][sum/2+1];
        for(int i = 1;i<=sum/2;i++){
            if(nums[0]==i) {
                dp[0][nums[0]] = true;
            }
        }
        for(int j = 1;j<=sum/2;j++){
            for(int i = 1;i<nums.length;i++){
                dp[i][j] = dp[i-1][j];
                if(nums[i]==j){
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i]<j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][sum/2];
    }
}
