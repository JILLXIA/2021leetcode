package Leetcode75.MergeStringsAlternately1768;

/**
 * You are given two strings word1 and word2.
 * Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 */
public class Solution {
    // word1, word2 can be ""?
    public String mergeAlternately(String word1, String word2) {
        if(word1.equals("")) {
            return word2;
        }

        if(word2.equals("")){
            return word1;
        }

        int index1 = 0;
        int index2 = 0;

        StringBuilder sb = new StringBuilder();
        while(index1 < word1.length() || index2 < word2.length()) {
            if(index1 < word1.length()) {
                sb.append(word1.charAt(index1));
                index1++;
            }

            if(index2 < word2.length()) {
                sb.append(word2.charAt(index2));
                index2++;
            }

        }
        return sb.toString();
    }
}
