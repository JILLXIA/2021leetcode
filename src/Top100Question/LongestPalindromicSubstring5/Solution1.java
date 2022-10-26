package Top100Question.LongestPalindromicSubstring5;

public class Solution1 {
    public String longestPalindrome(String s) {
        int length = 0;
        int start = 0;
        int end = 0;
        for(int i = 0;i<s.length();i++){
            int tmplength = Math.max(expandFromCenter(i,i,s),expandFromCenter(i,i+1,s));
            if(tmplength > length){
                start = i - (tmplength-1)/2;
                end = i+ tmplength/2;
                length = tmplength;
            }

        }
        return s.substring(start, end+1);
    }

    public int expandFromCenter(int left, int right, String s){
        while(left >=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
