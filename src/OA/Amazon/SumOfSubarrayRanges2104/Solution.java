package OA.Amazon.SumOfSubarrayRanges2104;

import java.util.Deque;
import java.util.LinkedList;
// shipment parcels
public class Solution {
    public long subArrayRanges(int[] nums) {
        int[] nextGreater = new int[nums.length];
        int[] nextSmaller= new int[nums.length];
        int[] preGreater = new int[nums.length];
        int[] preSmaller = new int[nums.length];
        int n = nums.length;
        Deque<Integer> deque = new LinkedList();
        // next greater
        for(int i = nums.length-1;i>=0;i--){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            nextGreater[i] = deque.isEmpty() ? n : deque.peekLast();
            deque.offerLast(i);
        }
        deque.clear();
        // next smaller
        for(int i = nums.length-1;i>=0;i--){
            while(!deque.isEmpty() && nums[deque.peekLast()] > nums[i]){
                deque.pollLast();
            }
            nextSmaller[i] = deque.isEmpty() ? n : deque.peekLast();
            deque.offerLast(i);
        }
        deque.clear();
        // pre greater or equal
        for(int i = 0;i<nums.length;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<= nums[i]){
                deque.pollLast();
            }
            preGreater[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.offerLast(i);
        }
        deque.clear();
        // pre smaller or Equal
        for(int i = 0;i<nums.length;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]>= nums[i]){
                deque.pollLast();
            }
            preSmaller[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.offerLast(i);
        }

        long sumMax = 0L;
        long sumMin = 0L;
        for(int i = 0;i<nums.length;i++){
            sumMax += (long)(i-preGreater[i])*(nextGreater[i] - i)*nums[i];
            sumMin += (long)(i-preSmaller[i])*(nextSmaller[i] - i)*nums[i];
        }
        return sumMax - sumMin;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subArrayRanges(new int[]{1,2,3}));
    }
}
