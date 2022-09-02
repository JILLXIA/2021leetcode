package OA.Amazon.temperature;

public class Solution {
    public int ans(int[] arr){
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for(int i = 1;i<preSum.length;i++){
            preSum[i] = preSum[i-1] + arr[i];
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            int tmp = Math.max(preSum[i],preSum[arr.length-1] - preSum[i] + arr[i]);
            result = Math.max(result,tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.ans(new int[]{-1,2,3}));
    }
}
