package 每日一题.打乱数组384;

import java.util.Random;

/**
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 */
public class Solution {
    // 利用Knuth洗牌算法
    // 我们从前往后尝试填充 [0, n - 1] 该填入什么数时，
    // 通过随机当前下标与（剩余的）哪个下标进行值交换来实现。
    int[] nums;
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = nums.clone(); // 复制一份一毛一样的数组
        for(int i = 0;i<ans.length;i++){
            swap(ans,i, i+random.nextInt(ans.length-i));
        }
        return ans;
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
