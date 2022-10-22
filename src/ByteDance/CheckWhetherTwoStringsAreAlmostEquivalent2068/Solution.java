package ByteDance.CheckWhetherTwoStringsAreAlmostEquivalent2068;

/**
 * Two strings word1 and word2 are considered almost
 * equivalent if the differences between the frequencies of each letter
 * from 'a' to 'z' between word1 and word2 is at most 3.
 *
 * Given two strings word1 and word2, each of length n,
 * return true if word1 and word2 are almost equivalent, or false otherwise.
 *
 * The frequency of a letter x is the number of times it occurs in the string.
 */
public class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] dp =  new int[26];

        for(int i = 0;i<word1.length();i++){
            dp[word1.charAt(i)-'a']++;
            dp[word2.charAt(i)-'a']--;
        }

        for(int i = 0;i<dp.length;i++){
            if(dp[i] > 3){
                return false;
            }
        }
        return true;
    }
}
