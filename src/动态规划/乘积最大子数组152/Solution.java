package 动态规划.乘积最大子数组152;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */

/**
 * 不断更新当前的最大值
 * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
 * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
 * 当负数出现时则imax与imin进行交换再进行下一步计算
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i = 0;i<nums.length;i++){
            int temp = 0;
            if(nums[i]<=0){
                temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax*nums[i],nums[i]);//要么算上前面的，要么从当前位置开始算
            imin = Math.min(imin*nums[i],nums[i]);

            result = Math.max(result,imax);
        }
        return result;
    }
}
