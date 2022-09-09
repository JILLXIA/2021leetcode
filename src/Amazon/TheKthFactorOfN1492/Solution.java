package Amazon.TheKthFactorOfN1492;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
 *
 * Consider a list of all factors of n sorted in ascending order,
 * return the kth factor in this list or return -1 if n has less than k factors.
 */
public class Solution {
    public int kthFactor(int n, int k) {
        // big root heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        int remainder = 0;
        int quotient = 0;
        for(int i = 1;i<=n;i++){
            remainder = n % i;
            quotient = n / i;
            if(quotient < i){
                break;
            }
            if(remainder != 0){
                continue;
            }
            priorityQueue.add(quotient);
            if(quotient != i){
                priorityQueue.add(i);
            }

            while(priorityQueue.size() > k){
                priorityQueue.poll();
            }

        }
        return priorityQueue.size() < k ? -1 : priorityQueue.peek();
    }
}
