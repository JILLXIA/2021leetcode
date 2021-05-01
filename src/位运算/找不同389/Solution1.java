package 位运算.找不同389;

/**
 * 碰到这种多一个的问题，可以使用求和法
 */
public class Solution1 {
    public char findTheDifference(String s, String t) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0;i<s.length();i++){
            sum1+=s.charAt(i);
        }
        for(int i = 0;i<t.length();i++){
            sum2+=t.charAt(i);
        }
        return (char)(sum2-sum1);
    }
}
