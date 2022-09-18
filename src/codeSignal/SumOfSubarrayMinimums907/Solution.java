package codeSignal.SumOfSubarrayMinimums907;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers arr,
 * find the sum of min(b), where b ranges over
 * every (contiguous) subarray of arr.
 *
 * Since the answer may be large, return the answer modulo 109 + 7.
 */
public class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] preSmaller = new int[arr.length];
        int[] nextSmaller = new int[arr.length];

        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0;i<arr.length;i++){
            // ascending stack
            while(!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]){
                deque.pollLast();
            }
            preSmaller[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.offerLast(i);
        }
        deque.clear();
        for(int i = arr.length-1;i >= 0;i--){
            // ascending stack
            while(!deque.isEmpty() && arr[deque.peekLast()] > arr[i]){
                deque.pollLast();
            }
            nextSmaller[i] = deque.isEmpty() ? arr.length : deque.peekLast();
            deque.offerLast(i);
        }

        long result = 0;
        for(int i = 0;i<arr.length;i++){
            result = (result + ((long) (i - preSmaller[i]) * (nextSmaller[i] - i) * arr[i])) % 1000000007;
        }
        return (int)result;
    }
}
