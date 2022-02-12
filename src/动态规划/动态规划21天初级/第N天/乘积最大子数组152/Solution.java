package 动态规划.动态规划21天初级.第N天.乘积最大子数组152;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];

        int max = nums[0];

        maxArr[0] = nums[0];
        minArr[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(minArr[i - 1] * nums[i]>maxArr[i - 1] * nums[i]) {
                maxArr[i] = Math.max(minArr[i - 1] * nums[i], nums[i]);
                minArr[i] = Math.min(maxArr[i - 1] * nums[i], nums[i]);
            }else{
                maxArr[i] = Math.max(maxArr[i - 1] * nums[i], nums[i]);
                minArr[i] = Math.min(minArr[i - 1] * nums[i], nums[i]);
            }

            max = Math.max(max,maxArr[i]);
        }
        return max;
    }
}
