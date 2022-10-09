package slidingWindow.LongestNiceSubstring1763;

import java.util.HashMap;

/**
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
 * For example, "abABB" is nice because 'A' and 'a' appear,
 * and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
 *
 * Given a string s, return the longest substring of s that is nice.
 * If there are multiple, return the substring of the earliest occurrence.
 * If there are none, return an empty string.
 */
public class Solution {
    public String longestNiceSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char rightc = s.charAt(right);
            right++;

        }
        return "";
    }
}
