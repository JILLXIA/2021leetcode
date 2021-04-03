package 数组.存在重复元素II219;

/**
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 */
/*
实际上找前k个就行了，往后面找实际上在浪费资源
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]==nums[j] && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;
    }
}
