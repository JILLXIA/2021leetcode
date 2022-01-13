package 每日一题.至少是其他数字两倍的最大数747;

/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 *
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。
 * 如果是，则返回 最大元素的下标 ，否则返回 -1 。
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE; // 最大的数
        int maxSec = Integer.MIN_VALUE; // 第二大的数
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>=max){
                maxSec = max;
                max = nums[i];
                result = i;
            }else if(nums[i]>=maxSec){
                maxSec = nums[i];
            }
        }
        return max>=2*maxSec ? result : -1;
    }
}
