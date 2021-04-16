package 字符串.制造字母异位词的最小步骤数1347;

/**
 * 给你两个长度相等的字符串s 和 t。每一个步骤中，
 * 你可以选择将t中的 任一字符 替换为 另一个字符。
 *
 * 返回使t成为s的字母异位词的最小步骤数。
 *
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
 */

/**
 * 与字母顺序无关的题目就想到哈希
 */
public class Solution {
    public int minSteps(String s, String t) {
        if(s.equals(t)){
            return 0;
        }
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for(int i = 0;i<s.length();i++){
            s1[s.charAt(i)-'a']++;
            t1[t.charAt(i)-'a']++;
        }
        int count = 0;
        for(int i = 0;i<26;i++){
            if(s1[i]<t1[i]){
                count+=t1[i]-s1[i];
            }
            count+=Math.abs(s1[i]-t1[i]);
        }
        return count/2;
    }
}
