package 字符串.仅仅反转字母917;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，
 * 其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 */
public class Solution {
    public String reverseOnlyLetters(String S) {
        char[] c = S.toCharArray();
        int left = 0;
        int right = S.length()-1;
        while(left<=right){
            while(left<=right && !isChar(c[left])){
                left++;
            }
            while(left<=right && !isChar(c[right])){
                right--;
            }
            if(left<right && c[left]!=c[right]){
                char tmp = c[left];
                c[left] = c[right];
                c[right] = tmp;
            }else if(left>=right){
                break;
            }
            left++;
            right--;
        }
        return String.valueOf(c);
    }

    public static boolean isChar(char c){
        if((c<='z'&&c>='a')||
                (c<='Z' && c>='A')){
            return true;
        }
        return false;
    }
}
