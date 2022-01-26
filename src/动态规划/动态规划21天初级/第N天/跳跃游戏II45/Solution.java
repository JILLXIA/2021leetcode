package 动态规划.动态规划21天初级.第N天.跳跃游戏II45;

/**
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int step = nums[0];
        int maxStep = 0;
        int count = 1;
        int result = 0;
        for(int i = 1;i<nums.length;i++){
            maxStep = Math.max(maxStep,nums[i]+i);
            result = count;

            if(i>=step){
                step = maxStep;
                maxStep = 0;
                count++;
            }
        }
        return result;
    }
}
