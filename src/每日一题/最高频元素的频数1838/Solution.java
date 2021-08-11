package 每日一题.最高频元素的频数1838;

import java.util.Arrays;

/**
 * 元素的 频数 是该元素在一个数组中出现的次数。
 *
 * 给你一个整数数组 nums 和一个整数 k 。
 * 在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 *
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 */

/**
 * https://www.bilibili.com/video/BV1Ai4y1P7Yt
 */
public class Solution {
    // 先排序，后用滑动窗口来解决
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int sum = 0;
        int targetSum = 0;
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            targetSum = nums[i]*(i-left+1);
            while(targetSum-sum>k){
                sum -= nums[left];
                left++;
                targetSum = nums[i]*(i-left+1);
            }
            result = Math.max(result,i-left+1);
        }
        return result;
    }
}
