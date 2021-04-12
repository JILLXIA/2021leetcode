package 字符串.破坏回文串1328;

/**
 * 给你一个回文字符串palindrome ，
 * 请你将其中一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，
 * 且不是回文串。
 *
 * 请你返回结果字符串。如果无法做到，则返回一个空串。
 */
public class Solution {
    public String breakPalindrome(String palindrome) {
        int pos = 0;
        int size = palindrome.length() % 2 == 0 ?(palindrome.length()-1)/2:(palindrome.length()-1)/2 - 1;
        char[] c = palindrome.toCharArray();
        for(int i = 0;i<=size;i++){
            if(c[i]!='a'){
                c[i] = 'a';
                return String.valueOf(c);
            }
            if(i==size && c[i]=='a'){
                c[c.length-1] = 'b';
                return String.valueOf(c);
            }
        }
        return "";
    }
}
