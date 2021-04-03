package 数组.存在重复元素II219;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * 在之前的方法中，我们知道了对数时间复杂度的 搜索 操作是不够的。在这个方法里面，
 * 我们需要一个支持在常量时间内完成 搜索，删除，插入 操作的数据结构，那就是散列表。
 * 这个算法的实现跟方法二几乎是一样的。
 */

/**
 * 这题要先想到滑动窗口，然后再找到插入，删除，查找最快速的数据结构来维护滑动窗口
 */
public class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                return true;
            }

            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
