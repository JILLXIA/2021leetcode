package ByteDance.NextGreaterElementII503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length * 2];
        for(int i = 0;i<nums.length;i++){
            arr[i] = nums[i];
            arr[i+nums.length] = nums[i];
        }
        int[] nextBigger = new int[nums.length * 2];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = arr.length-1;i>=0;i--){
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.pollLast();
            }
            nextBigger[i] = deque.isEmpty() ? -1 : arr[deque.peekLast()];
            deque.offerLast(i);
        }
        return Arrays.copyOfRange(nextBigger,0,nums.length);
    }
}
