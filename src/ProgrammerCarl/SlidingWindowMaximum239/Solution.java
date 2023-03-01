package ProgrammerCarl.SlidingWindowMaximum239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an array of integers nums,
 * there is a sliding window of size k which is moving
 * from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicStack ms = new MonotonicStack();
        int[] result = new int[nums.length - k + 1];
        for(int i = 0;i < nums.length;i++){
            if(i < k){
                ms.push(nums[i]);
            } else {
                result[i - k] = ms.max();

                if(nums[i-k] == ms.max()){
                    ms.pop();
                }
                ms.push(nums[i]);
            }
        }
        result[result.length - 1] = ms.max();
        return result;
    }
}

// use a monotonic stack with the decreasing order
class MonotonicStack{
    Deque<Integer> deque;
    public MonotonicStack(){
        deque = new LinkedList<Integer>();
    }

    public void push(int k){
        while(!deque.isEmpty() && k > deque.peekLast()){
            deque.pollLast();
        }
        deque.offerLast(k);
    }

    public int pop(){
        return deque.isEmpty() ? 0 : deque.pollFirst();
    }

    public int max(){
        return deque.isEmpty() ? 0 :deque.peekFirst();
    }
}