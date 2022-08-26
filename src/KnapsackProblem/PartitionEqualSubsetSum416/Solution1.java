package KnapsackProblem.PartitionEqualSubsetSum416;

public class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }

        if(sum % 2!=0){
            return false;
        }

        int weight = sum / 2;
        boolean[] dp = new boolean[weight + 1];
        dp[0] = true;
        for(int i = 1;i<= nums.length;i++){
            for(int j = dp.length-1;j>=0;j--){
                // 转成一维数组的时候记得从后面便利
                if(j-nums[i-1] < 0){
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                }
            }
        }
        return dp[dp.length-1];
    }
    // Time Complexity:- O(n*sum)
    // Space Complexity:- O(sum/2);
}
