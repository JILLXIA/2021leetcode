package 位运算.多数元素169;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;
        int tmp = nums[0];
        for(int i = 0;i<nums.length;i++){
            if(tmp==nums[i]){
                result++;
            }else if(tmp!=nums[i]){
                result--;
                if(result<0){
                    tmp = nums[i];
                    result = 1;
                }
            }
        }
        return tmp;
    }
}
