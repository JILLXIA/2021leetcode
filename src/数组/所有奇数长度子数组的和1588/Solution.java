package 数组.所有奇数长度子数组的和1588;

/**
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr中 所有奇数长度子数组的和 。
 */

/**
 * 初始想法是遍历一遍，计算每个数字出现的次数
 * 某个数如果前面有偶数个数，后面也一定有偶数个数，加上自己是奇数
 * 某个数如果前面有奇数个数，后面也一定有奇数个数，加上自己是奇数
 *
 * 数字前面共有 left 个选择，其中偶数个数字的选择方案有 left_even = (left + 1) / 2 个，奇数个数字的选择方案有 left_odd = left / 2 个；
 *
 * 数字后面共有 right 个选择，其中偶数个数字的选择方案有 right_even = (right + 1) / 2 个，奇数个数字的选择方案有 right_odd = right / 2 个；
 *
 * 所以，每个数字一共在 left_even * right_even + left_odd * right_odd 个奇数长度的数组中出现过。
 */
public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            int left = i+1;
            int right = arr.length-2;
            int left_odd = left/2;
            int right_odd = right / 2;

            int left_even = (left+1)/2 ;
            int right_even = (right+1)/2;

            sum +=arr[i]*(left_odd*right_odd+left_even*right_even);

        }
        return sum;
    }
}
