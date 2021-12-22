package 每日一题.重复叠加字符串匹配686;

/**
 * 给定两个字符串a 和 b，寻找重复叠加字符串 a 的最小次数，
 * 使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc"重复叠加 0 次是 ""，重复叠加 1 次是"abc"，
 * 重复叠加 2 次是"abcabc"。
 */
public class Solution {
    /**
     * 我们假设 b 的长度是 a 的 x 倍，主要有以下三种情况，分别举例说明：
     *
     * a 重复 x 次后正好等于 b，比如 a="ab", b="abab"，a 只需要重复 2 次即可；
     * a 重复 x 次后无法包含 b，比如 a="ab", b="ababa"，a 需要重复 3次才可以，也就是 x+1 次；
     * a 重复 x+1 次后也无法包含 b，比如 a="abc", b="cabcabca"，a 需要重复 4次才可以，也就是 x+2 次；
     * @param a
     * @param b
     * @return
     */
    public int repeatedStringMatch(String a, String b) {
        boolean[] barr = new boolean[26];
        for(int i = 0;i<a.length();i++){
            barr[a.charAt(i) - 'a'] = true;
        }
        for(int i = 0;i<b.length();i++){
            if(!barr[b.charAt(i) - 'a']){
                return -1;
            }
        }

        int count = b.length()/a.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<count;i++){
            sb.append(a);
        }
        for(int i = 0;i<=2;i++){
            if(sb.indexOf(b)>=0){
                return count + i;
            }
            sb.append(a);
        }
        return -1;
    }
}
