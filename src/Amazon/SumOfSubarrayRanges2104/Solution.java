package Amazon.SumOfSubarrayRanges2104;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
 *
 * Return the sum of all subarray ranges of nums.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class Solution {
    public long subArrayRanges(int[] nums) {
        int[] preSmallerOrEqual = new int[nums.length];
        int[] nextSmaller = new int[nums.length];
        int[] preBiggerOrEqual = new int[nums.length];
        int[] nextBigger = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();

        // pre - smaller--维持递增
        for(int i = 0;i<nums.length;i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] >= nums[i]){
                deque.pollLast();
            }
            preSmallerOrEqual[i] = deque.isEmpty() ? -1: deque.peekLast();
            deque.offerLast(i);
        }

        deque.clear();
        // pre-bigger--维持递减
        for(int i = 0;i<nums.length;i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            preBiggerOrEqual[i] = deque.isEmpty() ? -1: deque.peekLast();
            deque.offerLast(i);
        }

        deque.clear();
        // next-smaller
        for(int i = nums.length-1;i>=0;i--){
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]){
                deque.pollLast();
            }
            nextSmaller[i] = deque.isEmpty() ? nums.length: deque.peekLast();
            deque.offerLast(i);
        }

        deque.clear();
        // next-bigger
        for(int i = nums.length-1;i>=0;i--){
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            nextBigger[i] = deque.isEmpty() ? nums.length: deque.peekLast();
            deque.offerLast(i);
        }
        long max = 0;
        long min = 0;
        for(int i = 0;i<nums.length;i++){
            max += (long) nums[i] *(i-preBiggerOrEqual[i])*(nextBigger[i]-i);
            min += (long) nums[i] *(i-preSmallerOrEqual[i])*(nextSmaller[i]-i);
        }
        return max-min;
    }
}
