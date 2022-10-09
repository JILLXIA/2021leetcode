package slidingWindow.MaximumLengthOfRepeatedSubarray718;

/**
 * Given two integer arrays nums1 and nums2,
 * return the maximum length of a subarray that appears in both arrays.
 */
public class Solution {
    // 根之前的滑动窗口不一样，这个need的map不是确定的
    // 看题解发现并不是sliding window,得用dp来做
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int result = 0;
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else{
                    dp[i][j] = 0;
                }
                result = Math.max(result,dp[i][j]);
            }
        }
        return result;
    }
}
