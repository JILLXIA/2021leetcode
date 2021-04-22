package 位运算.只出现一次的数字136;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗
 */
//虽然可以用HashSet，但是用了额外的空间

/**
 * 用异或运算 a^0 = a; a^a = 0;满足交换律，结合律
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
}
