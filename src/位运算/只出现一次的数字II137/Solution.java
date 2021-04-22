package 位运算.只出现一次的数字II137;

/**
 * 给你一个整数数组 nums ，
 * 除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 */

/**
 * 将输入数组存储到 HashSet，然后使用 HashSet
 * 中数字和的三倍与数组之和比较。
 */

/**
 * 位运算不懂啊 //TODO
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            result ^= nums[i];

        }
        return 0;
    }
}
