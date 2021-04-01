package 数组.面试题1710主要元素;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 */

/*
遍历两次
存在HashMap里面，后面进行键值的判断
 */
public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],1);
            }else {
                int temp = map.get(nums[i]);
                temp++;
                map.put(nums[i],temp);//可以直接把之前的键值对覆盖了，不用先remove再put
            }
        }

        int maxNum = 0;
        int result = 0;
        Iterator<Map.Entry<Integer, Integer>> itor = map.entrySet().iterator();
        while(itor.hasNext()){
            Map.Entry entry = (Map.Entry)itor.next();
            if(maxNum<=(Integer)entry.getValue()){
                maxNum = (Integer)entry.getValue();
                result = (Integer)entry.getKey();
            }
        }

        if(maxNum>nums.length/2){
            return result;
        }else{
            return -1;
        }
    }
}
