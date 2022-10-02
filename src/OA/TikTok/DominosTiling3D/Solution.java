package OA.TikTok.DominosTiling3D;

import java.util.Arrays;
// https://www.quora.com/In-how-many-ways-can-you-fit-1-X-1-X-2-sized-dominoes-into-a-domino-of-dimensions-2-X-2-X-N-where-N-is-a-variable
public class Solution {
    public int[] checkDominos(int[] arr){
        long[] dp = new long[100005];
        int[] result = new int[arr.length];
        dp[1] = 2;
        dp[2] = 9;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        for(int i = 3;i<=max;i++){
            dp[i] = 4 * dp[i-1] - dp[i-2] + 2 * (long)Math.pow(-1,i);
        }

        for(int i = 0;i<result.length;i++){
            result[i] = (int) (dp[arr[i]] % (1e9+7));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.checkDominos(new int[]{1, 2, 3})));
    }
}
