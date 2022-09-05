package OA.Amazon.SumOfTotalStrengthOfWizards2281;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int[] nums = new int[n+1];
        long mod = (long) (1e9 + 7);
        for(int i = 1;i<nums.length;i++){
            nums[i] = strength[i-1];
        }

        long[] preSum = new long[n+2];
        long[] preSum2 = new long[n+2];
        for(int i=1;i<=n;i++){
            preSum[i] = (preSum[i-1]+(long)nums[i])%mod;
            preSum2[i] = (preSum2[i-1] + (long)nums[i] * i) % mod;
        }

        int[] preSmaller = new int[n+2]; // pre Small or equal
        int[] nextSmaller = new int[n+2];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] >= nums[i]){
                deque.pollLast();
            }
            preSmaller[i] = deque.isEmpty() ? 0 : deque.peekLast();
            deque.offerLast(i);
        }
        deque.clear();
        for(int i = n ;i>=1;i--){
            while(!deque.isEmpty() && nums[deque.peekLast()] > nums[i]){
                deque.pollLast();
            }
            nextSmaller[i] = deque.isEmpty() ? n+1 : deque.peekLast();
            deque.offerLast(i);
        }

        long result = 0;
        for(int i = 1;i<=n;i++){
            int a = preSmaller[i];
            int b = nextSmaller[i];
            long x = i-a;
            long y = b-i;
            long first = ((preSum2[i-1] - preSum2[a]) - (preSum[i-1] - preSum[a]) * a %mod + mod) % mod;
            first = first * y % mod;
            long second = ((preSum[b-1] - preSum[i]) * (b-1+1) - (preSum2[b-1] - preSum2[i]) + mod ) % mod;
            second = second * x % mod;
            long mid = (long)nums[i] * x * y % mod;

            result = (result +(first + second + mid) * nums[i]) % mod;
        }
        return (int) result;
    }
}
