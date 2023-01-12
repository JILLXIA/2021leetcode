package Grind75.RansomNote383;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for(int i = 0;i<magazine.length();i++){
            hash[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0;i<ransomNote.length();i++){
            if(hash[ransomNote.charAt(i) - 'a']==0){
                return false;
            }
            hash[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }
}
