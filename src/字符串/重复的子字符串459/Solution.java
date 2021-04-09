package 字符串.重复的子字符串459;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()<=1){
            return false;
        }
        int right = 1;
        while(right<=s.length()/2){
            if(check(s.substring(0,right),s.substring(right))){
                return true;
            }
            right++;
        }
        return false;
    }
    public static boolean check(String tmp,String rest){
        int pos = tmp.length()-1;
        while(pos<rest.length()){
            if(!rest.substring(pos-(tmp.length()-1),pos+1).equals(tmp)){
                return false;
            }
            pos += tmp.length();
        }
        if(pos-(tmp.length()-1)!=rest.length()){
            return false;
        }
        return true;

    }
}
