package 每日一题.查找和最小的K对数字373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数 k。
 *
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 *
 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a,b)->nums1[a.get(0)]+nums2[a.get(1)]-nums1[b.get(0)]-nums2[b.get(1)]);
        // 多路并归存下标
        for(int i = 0;i<nums1.length;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            tmp.add(0);
            queue.add(tmp);
        }

        while(!queue.isEmpty() && k>0){
            List<Integer> tmp = queue.poll();
            List<Integer> tmpResult = new ArrayList<>();
            tmpResult.add(nums1[tmp.get(0)]);
            tmpResult.add(nums2[tmp.get(1)]);
            result.add(tmpResult);

            if(tmp.get(1)+1< nums2.length) {
                List<Integer> addList = new ArrayList<>();
                addList.add(tmp.get(0));
                addList.add(tmp.get(1) + 1);
                queue.add(addList);
            }
            k--;
        }
        return result;
    }
}
