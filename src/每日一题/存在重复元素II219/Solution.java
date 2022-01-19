package 每日一题.存在重复元素II219;

import java.util.HashMap;

/**
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                int value = map.get(nums[i]);
                if(i-value<=k){
                    return true;
                }else {
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
