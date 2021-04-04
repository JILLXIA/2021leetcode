package 数组.绝对差不超过限制的最长连续子数组1438;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 用双端队列来维护最小值和最大值
 * 队列插入删除查找都是线性时间
 */
public class Solution2 {
    public int longestSubarray(int[] nums, int limit) {
        int count = 0;//子数组的最大长度
        Deque<Integer> minQue = new LinkedList<>();//永远保证最小值在队列最前面
        Deque<Integer> maxQue = new LinkedList<>();//永远保证最大值在队列最前面
        int left = 0;//滑动窗口左端
        int position = 0;

        //合理的长度一定是等left缩到合适位置的时候
        while(position<nums.length){
            while(!minQue.isEmpty()&&minQue.peekLast()>nums[position]){
                minQue.pollLast();//保证单调性
            }
            while(!maxQue.isEmpty()&&maxQue.peekLast()<nums[position]){
                maxQue.pollLast();
            }
            minQue.offerLast(nums[position]);
            maxQue.offerLast(nums[position]);

            //判断扩张之后的数组是否合理
            //如果不合理要移动left到合理的地方
            while(left<position && maxQue.peekFirst()-minQue.peekFirst()>limit){
                if(maxQue.peekFirst() == nums[left]){
                    maxQue.pollFirst();
                }else if(minQue.peekFirst() == nums[left]){
                    minQue.pollFirst();
                }
                left++;
            }
            count = Math.max(count,position-left+1);
            position++;
        }

        return count;
    }
}
