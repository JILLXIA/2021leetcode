package 数组.有序数组的平方977;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */

/**
 * 这个解法没有利用上原数组就是单调的这一条件
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            arr[i] = nums[i] * nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }
}
