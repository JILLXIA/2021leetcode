package 每日一题.赎金信383;

/**
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，
 * 判断 ransomNote 能不能由 magazines 里面的字符构成。
 *
 * 如果可以构成，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mag = new int[26];
        for(int i = 0;i<magazine.length();i++){
            mag[magazine.charAt(i)-'a']++;
        }
        for(int i = 0;i<ransomNote.length();i++){
            if(mag[ransomNote.charAt(i)-'a']<=0){
                return false;
            }
            mag[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }
}
