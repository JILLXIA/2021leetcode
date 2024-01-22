package Grind75.LongestPalindrome409;

import java.util.HashMap;

/**
 * Given a string s which consists of lowercase or uppercase letters,
 * return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < s.length() ;i++){
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int result = 0;
        boolean haveUseSingle = false;
        for(Character c: hashMap.keySet()) {
            if(hashMap.get(c) % 2 == 0) {
                result += hashMap.get(c);
            } else if(!haveUseSingle){
                result += hashMap.get(c);
                haveUseSingle = true;
            } else {
                result += hashMap.get(c) - 1;
            }
        }
        return result;
    }
}
