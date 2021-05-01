package 位运算.找不同389;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] snum = new int[26];
        int[] tnum = new int[26];
        for(int i = 0;i<t.length();i++){
            if(i!=t.length()-1){
                snum[s.charAt(i)-'a']++;
                tnum[t.charAt(i)-'a']++;
            }else{
                tnum[t.charAt(i)-'a']++;
            }
        }
        for(int i = 0;i<26;i++){
            if(snum[i]!=tnum[i]){
                return (char)('a'+i);
            }
        }
        return ' ';
    }
}
