package 位运算.只出现一次的数字III260;

/**
 * 给定一个整数数组 nums，
 * 其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 */

/**
 * 分组异或，如何分组呢？分组的结果应该满足以下条件
 * 1. 不同的两个数字分在不同的组
 * 2. 相同的数字在相同的组
 *
 * 先全员异或，得到的结果h
 * 找h为1的任意一位，再遍历所有数组这一位是0的分一组，是1的分到另外一组
 * 分组之后在分组异或
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int tmp = nums[0];
        int a=0;
        int b=0;
        int h = 1;
        for(int i = 1;i<nums.length;i++){
            tmp = tmp ^ nums[i];
        }
        //tmp是全员异或的结果

        //找到是1的任意一位
        while((h & tmp)==0){
            h = h<<1;
        }

        //分组异或
        for(int i = 0;i<nums.length;i++){
            if((nums[i]&h)==0){
                a = a^nums[i];
            }else{
                b = b^nums[i];
            }
        }
        return new int[]{a, b};
    }
}
