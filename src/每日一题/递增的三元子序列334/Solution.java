package 每日一题.递增的三元子序列334;

/**
 * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，
 * 使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 贪心算法，两个数存储small,middle，遇到比small小的更新small，遇到比middle小的更新middle
        if(nums.length<3){
            return false;
        }
        int small = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        for(int i = 0;i<nums.length;i++){
            if(nums[i]<=small){
                small = nums[i];
            }else if(nums[i]<=middle){
                middle = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
