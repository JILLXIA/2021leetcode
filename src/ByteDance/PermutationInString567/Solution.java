package ByteDance.PermutationInString567;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        int[] dict = new int[26];
        int[] match = new int[26];
        for(int i = 0;i<s1.length();i++){
            dict[s1.charAt(i)-'a']++;
        }

        int right = s1.length();
        for(int i = 0;i<right;i++){
            match[s2.charAt(i) - 'a']++;
        }
        if(checkMatch(dict, match)){
            return true;
        }
        for(int i = right;i<s2.length();i++){
            match[s2.charAt(i)-'a']++;
            match[s2.charAt(i - right)-'a']--;
            if(checkMatch(dict, match)){
                return true;
            }
        }
        return false;
    }

    public boolean checkMatch(int[] dict, int[] match){
        for(int i = 0;i<26;i++){
            if(dict[i]==match[i]){
                continue;
            }
            return false;
        }
        return true;
    }
}
