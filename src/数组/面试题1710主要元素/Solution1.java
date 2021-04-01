package 数组.面试题1710主要元素;

/**
 * 用摩尔投票法
 * 遍历数组，从第一个元素开始计数，计数器初始为 1。
 * 遇到与当前元素相同的元素时，计数器加 1，否则减 1（比拼消耗）。
 * 若计数器为 0，则重新从当前元素开始计数，重复步骤 2 直至到达数组末尾。
 *
 * 存在两种情况： 1.主要元素一定存在的话，则一定可以抵消到最后(count被抵消过一部分了，所以还要遍历一边加上抵消过的部分)；2.主要元素不存在的话，也可以剩下最后个元素。
 * 再确认一下是否真的存在
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int result = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(result == nums[i]){
                count++;
            }else{
                count--;
            }

            if(count==0){
                result = nums[i];
                count=1;
            }
        }
        int vote = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==result){
                vote++;
            }
        }
        if(vote>nums.length/2){
            return result;
        }else{
            return -1;
        }
    }
}
