package 数组.汇总区间228;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        Deque<Integer> minQue = new LinkedList<>();
        Deque<Integer> maxQue = new LinkedList<>();
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        minQue.offerLast(nums[0]);
        maxQue.offerLast(nums[0]);
        for(int i = 1;i<nums.length;i++){
            if(!maxQue.isEmpty()&&nums[i]-maxQue.peekLast()==1){
                maxQue.pollLast();
            }else if(!maxQue.isEmpty()&&nums[i]-maxQue.peekLast()!=1){
                String temp;
                if(minQue.peekLast()-maxQue.peekLast()!=0) {
                    temp = minQue.peekLast().toString() + "->" + maxQue.peekLast().toString();
                }else{
                    temp = minQue.peekLast().toString();
                }
                result.add(temp);
                minQue.offerLast(nums[i]);
            }

            maxQue.offerLast(nums[i]);
        }
        String finalString;
        if(minQue.peekLast()-maxQue.peekLast()!=0) {
            finalString = minQue.peekLast().toString() + "->" + maxQue.peekLast().toString();
        }else{
            finalString = minQue.peekLast().toString();
        }
        result.add(finalString);
        return result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] arr = {-2147483648,-2147483647,2147483647};
        System.out.println(s.summaryRanges(arr));
    }
}
