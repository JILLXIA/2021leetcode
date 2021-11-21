package 每日一题.最长和谐子序列594;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 */
public class Solution {
    public int findLHS(int[] nums) {
        // 可以先排序，遇到子序列和排序有关的问题的时候
        // 利用HashMap存储次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int result = 0;
        for(int key:map.keySet()){
            if(map.containsKey(key+1)) {
                result = Math.max(result, map.get(key) + map.get(key + 1));
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution s  = new Solution();
        System.out.println(s.findLHS(new int[]{1,2,3,4}));
    }
}
