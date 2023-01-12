package ProgrammerCarl.MinimumWindowSubstring76;

import java.util.HashMap;
import java.util.Objects;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window
 * substring
 *  of s such that every character in t (including duplicates)
 *  is included in the window. If there is no such substring,
 *  return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */
public class Solution {
    public String minWindow(String s, String t) {
        // length of string s: |S|; length of string t: |T|
        // time complexity: O(|S| + |T|)
        // space complextiy: O(|S| + |T|)
        HashMap<Character, Integer> dictMap = new HashMap<>();
        for(int i = 0; i < t.length();i++){
            dictMap.put(t.charAt(i), dictMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        String result = "";

        while(right < s.length()){
            char rightc = s.charAt(right);
            right++;

            window.put(rightc, window.getOrDefault(rightc, 0) + 1);

//            if(Objects.equals(window.get(rightc), dictMap.get(rightc))){
//                valid++;
//            }

            if(dictMap.containsKey(rightc) && window.get(rightc).intValue()== dictMap.get(rightc).intValue()){
                valid++;
            }

            while(valid==dictMap.size()){
                if(right - left < minLength){
                    minLength = right - left;
                    result = s.substring(left, right);
                }
                char leftc = s.charAt(left);
                left++;
                if(Objects.equals(window.get(leftc), dictMap.get(leftc))){
                    valid--;
                }
                window.put(leftc, window.get(leftc) - 1);
            }
        }
        return result;
    }
}
