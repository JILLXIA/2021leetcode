package OA.TikTok.CountBinarySubstrings696;

/**
 * Given a binary string s,
 * return the number of non-empty substrings that have the same
 * number of 0's and 1's, and all the 0's and all the 1's in these
 * substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int count0 = 0;
        int count1 = 0;
        int result = 0;

        for(int i = 0;i<s.length();i++){
            if(i==0 || s.charAt(i)!=s.charAt(i-1)){
                result += Math.min(count0,count1);
                if(s.charAt(i)=='0'){
                    count0 = 1;
                } else {
                    count1 = 1;
                }
            } else {
                if(s.charAt(i)=='0'){
                    count0++;
                } else {
                    count1++;
                }
            }
        }
        result += Math.min(count0,count1);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countBinarySubstrings("00110011"));
    }
}
