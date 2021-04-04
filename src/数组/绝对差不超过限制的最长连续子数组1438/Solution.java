package 数组.绝对差不超过限制的最长连续子数组1438;

import java.util.TreeSet;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，
 * 请你返回最长连续子数组的长度，
 * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 */

/**
 * 数组里面会有相同的元素，所以TreeSet无法完全满足
 * 不仅要记录出现的元素，还要记录他们出现的个数，所以要用TreeMap
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int count = 1;//子数组的最大长度
        TreeSet<Integer> set = new TreeSet<>();
        int left = 0;//滑动窗口左端
        int position = 1;
        if(nums.length==1){
            return 1;
        }

        set.add(nums[0]);
        int rlp = 0;
        while(left<=position && position<nums.length){
            if(Math.abs(nums[position]-set.first())<=limit &&
            Math.abs(nums[position]-set.last())<=limit){
                if(set.contains(nums[position])){
                    rlp++;
                }
                set.add(nums[position]);
                position++;
            }else{
                set.remove(nums[left]);
                left++;
                if(left==position){
                    set.add(nums[left]);
                    position++;
                }
            }
            if(set.size()+rlp>=count){
                count=set.size()+rlp;
            }
        }
        return count;
    }
}
