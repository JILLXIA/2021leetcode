package 字符串.字符串压缩面试题0106;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 */
public class Solution {
    public String compressString(String s) {
        if(s.length()<=2){
            return s;
        }

        StringBuilder result = new StringBuilder();
        int left = 0;
        int right = 1;

        while(left<s.length()){
            char c = s.charAt(left);
            while(right<s.length() && s.charAt(right)==c){
                right++;
            }
            result.append(c);
            result.append(right-left);

            left = right;
            right = right+1;
        }
        if(result.length()>=s.length()){
            return s;
        }else{
            return result.toString();
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.compressString("bbbac"));
    }
}
