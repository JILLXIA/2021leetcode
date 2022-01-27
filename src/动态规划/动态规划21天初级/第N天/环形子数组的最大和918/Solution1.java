package 动态规划.动态规划21天初级.第N天.环形子数组的最大和918;
// 如果最大的在两边，就找中间的最小的！！
// 因为数组的和始终是不变的，找到最小的剩下的必定是最大的

/**
 * max(前缀数组+后缀数组)
 * = max(数组总和 - subarray) subarray指的是前缀数组和后缀数组中间的数组
 * = 数组总和 + max(-subarray) 数组总和是不变的，直接提出来
 * = 数组总和 - min(subarry) 。。。这个都懂吧，把负号提出来，max变成min
 */
public class Solution1 {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = nums[0];
        int max = nums[0];
        int curMin = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for(int i = 1;i<nums.length;i++){
            curMax = Math.max(nums[i],nums[i]+curMax);
            curMin = Math.min(nums[i],nums[i]+curMin);
            max = Math.max(max,curMax);
            min = Math.min(min,curMin);
            sum += nums[i];
        }
        return max >=0 ? Math.max(max,sum-min) : max;
    }
}
