package 动态规划.目标和494;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加'+' 或 '-' ，
 * 然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，
 * 在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 注意nums的每一个元素都是正数
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(Math.abs(target) > sum){
            return 0;
        }
        // 这道题有个坑的地方，就是nums[0]可能等于0，
        // 这样初始化dp数组第一行的时候很可能踩坑，
        // 因为如果nums[0]==0那么dp[0][sum]需要初始化为2，
        // 因为加减0都得0。
        int[][] dp = new int[nums.length][2*sum+1];
        if(nums[0] == 0){
            dp[0][sum] = 2;
        }else{
            dp[0][sum-nums[0]] = 1;
            dp[0][sum+nums[0]] = 1;
        }

        for(int i = 1;i<dp.length;i++){
            for(int j = 0;j<2*sum+1;j++){
                int temp = j >= nums[i] ? dp[i-1][j-nums[i]] : 0;
                temp = j + nums[i] < 2*sum +1 ? temp+dp[i-1][j+nums[i]] : temp;
                dp[i][j] = temp;
            }
        }
        return dp[nums.length-1][target+sum];
    }
}
