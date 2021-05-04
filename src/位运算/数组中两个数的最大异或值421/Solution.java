package 位运算.数组中两个数的最大异或值421;

/**
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，
 * 其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 找最长不同的前缀
 */

/**
 * 具体思路也是先猜答案，然后再验证
 * 用了TwoSum的思想
 *
 * 唯一不足的地方在于没有剪枝，比如第一位没有符合的数字没有再第一次就剔除掉
 */
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int result = 0;
        int maxNum = nums[0];
        for(int i = 0;i<nums.length;i++){
            maxNum = Math.max(maxNum,nums[i]);
        }
        int l = Integer.toBinaryString(maxNum).length();
        int mask = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<l;i++){
            int tmp = mask | 1<<(l-i-1);
            set.clear();
            for(int j = 0;j<nums.length;j++){
                set.add(nums[j]&tmp);
            }

            //a^b = c; a^c = b;
            for(int sset:set){
                if(set.contains(sset^tmp)){
                    mask = tmp;
                    break;
                }
            }
        }

        return mask;
    }
}
