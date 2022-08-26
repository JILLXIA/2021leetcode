package KnapsackProblem.PartitionEqualSubsetSum416;

/**
 * Given a non-empty array nums containing only
 * positive integers, find if the array can be partitioned
 * into two subsets such that the sum of elements in both
 * subsets is equal.
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }

        if(sum % 2!=0){
            return false;
        }

        int weight = sum / 2;
        boolean[][] dp = new boolean[nums.length+1][weight + 1];
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = true;// 背包空间为0的时候肯定可以装满
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(j - nums[i-1] < 0){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    // Time Complexity:- O(n*sum)
    // Space Complexity:- O(sum);
}
