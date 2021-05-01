package 位运算.找不同389;

public class Solution2 {
    public char findTheDifference(String s, String t) {
        int ret = 0;
        for(int i = 0;i<s.length();i++){
            ret ^=s.charAt(i);
        }
        for(int i = 0;i<t.length();i++){
            ret ^=t.charAt(i);
        }
        return (char)ret;
    }
}
