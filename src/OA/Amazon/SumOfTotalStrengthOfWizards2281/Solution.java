package OA.Amazon.SumOfTotalStrengthOfWizards2281;

import java.util.Deque;
import java.util.LinkedList;

/**
 * As the ruler of a kingdom, you have an army of wizards at your command.
 *
 * You are given a 0-indexed integer array strength, where strength[i] denotes the strength of the ith wizard. For a contiguous group of wizards (i.e. the wizards' strengths form a subarray of strength), the total strength is defined as the product of the following two values:
 *
 * The strength of the weakest wizard in the group.
 * The total of all the individual strengths of the wizards in the group.
 * Return the sum of the total strengths of all contiguous groups of wizards. Since the answer may be very large, return it modulo 109 + 7.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class Solution {
    // bug de 不出来了
    // 换一种解法
    public int totalStrength(int[] strength) {
        long[] preSum = new long[strength.length+1];
        long mod = (long) (1e9 + 7);
        for(int i = 1;i<preSum.length;i++){
            preSum[i] = (preSum[i-1] + (long)strength[i-1])%mod;
        }

        long[] preSum2 = new long[preSum.length];
        preSum2[0] = 0;
        for(int i = 1;i<preSum2.length;i++){
            preSum2[i] = (preSum2[i-1] + (long) strength[i-1] * i)%mod;
        }


        int[] preSmaller = new int[strength.length]; // pre Small or equal
        int[] nextSmaller = new int[strength.length];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<preSmaller.length;i++){
            while(!deque.isEmpty() && strength[deque.peekLast()] >= strength[i]){
                deque.pollLast();
            }
            preSmaller[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.offerLast(i);
        }
        deque.clear();
        for(int i = nextSmaller.length - 1;i>=0;i--){
            while(!deque.isEmpty() && strength[deque.peekLast()] > strength[i]){
                deque.pollLast();
            }
            nextSmaller[i] = deque.isEmpty() ? nextSmaller.length : deque.peekLast();
            deque.offerLast(i);
        }
        long result = 0L;
        for(int i = 1;i<=strength.length;i++){
            int a = preSmaller[i-1];
            int b = nextSmaller[i-1];
            int x = i-a;
            int y = b-i;
            long left = preSum2[i-1] - preSum2[a+1] - (preSum[i-1] - preSum[a+1])*a;
            long right = (preSum[b-1] - preSum[i])*b - (preSum2[b-1] - preSum2[i]);
            long mid = (long) strength[i - 1] *x *y;
            result += (left + right + mid) * strength[i-1] % mod;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalStrength(new int[]{1,3,1,2}));
    }
}

