package 数组.三个数的最大乘积628;

import java.util.Arrays;

/**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */

/**
 * 别把情况想那么复杂，排序之后，要么是两个负数和最大正数的乘积，要么是三个最大正数的乘积
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);

    }
}
