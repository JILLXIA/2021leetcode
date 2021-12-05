package 每日一题.K次取反后最大化的数组和1005;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 */
public class Solution {
    // 找到绝对值最小的
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 由于nums[i]在-100到100之间，所以可以建立数组
        int[] arr = new int[201];
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]+100]++; // arr存的是数出现的次数
        }
        int index = 0;// 遍历的下标

        while(k>0){
            while(arr[index]==0){
                index++;
            }// 找到第一个最小的数

            arr[index]--;// 最小的数取反
            arr[200-index]++;//取反后的数出现的次数++

            // 如果一开始是个正数，取反之后就成了负的，index也要变化
            if(index>=100){
                index = 200-index;
            }
            k--;
        }

        int sum = 0;
        for(int i = index;i<arr.length;i++){
            if(arr[i]!=0){
                sum += (i-100)*arr[i];
            }
        }
        return sum;

    }
}
