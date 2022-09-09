package Amazon.CountBinarySubstrings696;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary string s, return the number of non-empty
 * substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int count = 1;
        List<Integer> freqList = new ArrayList<>();
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            } else {
                freqList.add(count);
                count  = 1;
            }
        }
        freqList.add(count);
        int result = 0;
        for(int i = 0;i<freqList.size()-1;i++){
            result += Math.min(freqList.get(i),freqList.get(i+1));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countBinarySubstrings("10101"));
    }
}
