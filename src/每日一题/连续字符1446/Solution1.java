package 每日一题.连续字符1446;

public class Solution1 {
    public int maxPower(String s) {
        int max = 1;
        int tmp = 1;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)){
                tmp++;
            }else{
                max = Math.max(tmp,max);
                tmp = 1;
            }
        }
        return max;
    }
}
