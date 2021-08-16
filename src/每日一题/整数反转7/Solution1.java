package 每日一题.整数反转7;

public class Solution1 {
    public int reverse(int x) {
        int result = 0;
        while(x!=0){
            if(result<Integer.MIN_VALUE/10 || result>Integer.MAX_VALUE/10){
                return 0;
            }
            result = result * 10 + (x%10);
            x = x/10;
        }
        return result;
    }
}
