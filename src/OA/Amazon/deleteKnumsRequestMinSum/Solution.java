package OA.Amazon.deleteKnumsRequestMinSum;

public class Solution {
    public int minSum(int[] arr, int k){
        // 剩下的最小和 =》 k个连续元素最大和 =》 sliding window
        int windowSum = 0;
        int sum = 0;
        for(int i = 0;i<k;i++){
            windowSum += arr[i];
            sum += arr[i];
        }

        int result = windowSum;
        for(int i = k;i<arr.length;i++){
            sum += arr[i];
            windowSum = windowSum + arr[i] - arr[i-k];
            result = Math.max(result,windowSum);
        }
        return sum - result;
    }

    public static void main(String[] args) {
        Solution s  = new Solution();
        System.out.println(s.minSum(new int[]{7,3,6,1},2));
    }
}
