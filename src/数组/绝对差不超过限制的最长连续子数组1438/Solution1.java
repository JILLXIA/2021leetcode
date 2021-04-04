package 数组.绝对差不超过限制的最长连续子数组1438;

import java.util.TreeMap;
import java.util.TreeSet;

public class Solution1 {
    public int longestSubarray(int[] nums, int limit) {
        int count = 0;//子数组的最大长度
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int left = 0;//滑动窗口左端
        int position = 0;

        //合理的长度一定是等left缩到合适位置的时候
        while(position<nums.length){
            map.put(nums[position],map.getOrDefault(nums[position],0)+1);
            //往后扩一个

            //判断扩张之后的数组是否合理
            //如果不合理要移动left到合理的地方
            while(left<position && Math.abs(map.lastKey()-map.firstKey())>limit){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])<=0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count = Math.max(count,position-left+1);
            position++;
        }

        return count;
    }
}
