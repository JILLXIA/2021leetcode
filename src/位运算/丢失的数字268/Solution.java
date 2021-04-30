package 位运算.丢失的数字268;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，
 * 找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */

/**
 * 利用两个相同的数异或==0的性质
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int tmp = nums[0];
        for(int i = 1;i<nums.length;i++){
            tmp  = tmp ^ nums[i];
        }
        for(int i = 0;i<=nums.length;i++){
            tmp = tmp ^ i;
        }
        return tmp;
    }
}
