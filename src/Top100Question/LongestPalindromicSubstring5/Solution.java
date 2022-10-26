package Top100Question.LongestPalindromicSubstring5;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * A string is called a palindrome string if the
 * reverse of that string is the same as the original string.
 */
public class Solution {
    public String longestPalindrome(String s) {
        int length = 0;
        String result = "";
        for(int i = 0;i<s.length();i++){
            int[] len1 = expandFromCenter(i,i,s);
            int[] len2 = new int[]{0,0};
            if(i!=s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                len2 = expandFromCenter(i,i+1,s);
            }
            if(len1[1] - len1[0] + 1 > length){
                length = len1[1] - len1[0] + 1;
                result = s.substring(len1[0],len1[1]+1);
            }
            if(len2[1] - len2[0] + 1 > length){
                length = len2[1] - len2[0] + 1;
                result = s.substring(len2[0],len2[1]+1);
            }
        }
        return result;
    }

    public int[] expandFromCenter(int left, int right, String s){
        while(left - 1>=0 && right + 1<s.length() && s.charAt(left-1)==s.charAt(right+1)){
            left--;
            right++;
        }
        return new int[]{left,right};
    }
}
