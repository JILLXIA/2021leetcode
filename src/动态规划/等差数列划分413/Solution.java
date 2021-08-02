package 动态规划.等差数列划分413;

/**
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，
 * 则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。
 */

/**
 * dp[i]表示当前下标所能表示的等差数列的数量。
 * dp[3]:234,1234就不包括123了
 * dp[4]:345,2345,12345
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = 0;
        for(int i = 2;i<nums.length;i++){
            if(nums[i-1]-nums[i-2]==nums[i]-nums[i-1]){
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        s.numberOfArithmeticSlices(new int[]{1,2,3,4});
    }
}
