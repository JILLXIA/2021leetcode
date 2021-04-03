package 数组.存在重复元素II219;

import java.util.TreeSet;

/**
 * 线性的查找是很慢的，所以考虑使用BST查找
 * TreeSet（无序，但可排序）
 * 滑动窗口
 * 节省了查找的时间
 * BST 中搜索，删除，插入都可以保持 O(logk) 的时间复杂度，其中 k 是 BST 中元素的个数。
 */
public class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
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
