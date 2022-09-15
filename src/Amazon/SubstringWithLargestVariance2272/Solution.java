package Amazon.SubstringWithLargestVariance2272;

/**
 * The variance of a string is defined as the largest difference
 * between the number of occurrences of any 2 characters present in the string.
 * Note the two characters may or may not be the same.
 *
 * Given a string s consisting of lowercase English letters only,
 * return the largest variance possible among all substrings of s.
 *
 * A substring is a contiguous sequence of characters within a string.
 */
public class Solution {
    public int largestVariance(String s) {
        // 问题转化为求nums数组中最大的子数组，但是需要保证有1，-1，就要从前从后分别找
        int[] sArr = new int[26];
        for(int i = 0;i<s.length();i++){
            sArr[s.charAt(i) - 'a']++;
        }
        int result = 0;
        for(int i = 0;i<26;i++){
            for(int j = 0;j<26;j++){
                if(sArr[i]==0 || sArr[j]==0){
                    continue;
                }
                if(i==j){
                    continue;
                }
                int[] nums = new int[s.length()];
                for(int k = 0;k<s.length();k++){
                    if(s.charAt(k) - 'a'==i){
                        nums[k] = 1;
                    } else if(s.charAt(k) - 'a'==j){
                        nums[k] = -1;
                    }
                }
                result = Math.max(result,check(nums));
            }
        }
        return result;
    }

    public int check(int[] nums){
        int[] dp1 = new int[nums.length]; // 以i为最后一位，前面的子数组的最大值
        dp1[0] = nums[0];
        for(int i = 1;i<dp1.length;i++){
            dp1[i] = Math.max(nums[i],dp1[i-1] + nums[i]);
        }

        int rearMax = 0;
        int result = 0;
        for(int i = nums.length - 1;i >= 0;i--){
            rearMax = Math.max(nums[i],rearMax + nums[i]);
            if(nums[i]==-1){
                result = Math.max(result, dp1[i] + rearMax - nums[i]);
            }
        }
        return result;
    }
}
