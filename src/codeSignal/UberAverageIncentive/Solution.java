package codeSignal.UberAverageIncentive;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用单调栈解决问题
 */
public class Solution {
    public int findAverageIncentive(int[] nums){
        // 假设当前的元素是最小的，算每一个元素最小的时候产生的最大值
        int[] preSmaller = new int[nums.length];
        int[] nextSmaller = new int[nums.length];

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            preSum[i] = preSum[i-1] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();
        // pre Smaller
        for(int i = 0;i<nums.length;i++){
            while(!deque.isEmpty() && nums[i] < nums[deque.peekLast()]){
                deque.pollLast();
            }
            preSmaller[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.offerLast(i);
        }
        deque.clear();
        // next Smaller
        for(int i = nums.length-1;i >=0 ;i--){
            while(!deque.isEmpty() && nums[i] < nums[deque.peekLast()]){
                deque.pollLast();
            }
            nextSmaller[i] = deque.isEmpty() ? nums.length : deque.peekLast();
            deque.offerLast(i);
        }

        int result = 0;
        for(int i = 0;i<nums.length;i++){
            int leftSum = preSmaller[i]==-1 ? 0 : preSum[preSmaller[i]];
            int subSum = preSum[nextSmaller[i]-1]-leftSum;
            result = Math.max(result, subSum * nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAverageIncentive(new int[]{2,1,3,4}));
        System.out.println(s.findAverageIncentive(new int[]{6,2,5,8,7,6}));
    }
}
