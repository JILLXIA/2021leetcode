package 动态规划.动态规划21天初级.第一天.第N个泰波拉切术1137;

/**
 * 泰波那契序列Tn定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 */
public class Solution {
    public int tribonacci(int n) {
        int num1 = 0;
        int num2 = 1;
        int num3 = 1;
        if(n<=2){
            return n==0? num1:num2;
        }
        int result = 0;
        for(int i = 3;i<=n;i++){
            result = num1+num2+num3;
            num1 = num2;
            num2 = num3;
            num3 = result;
        }
        return result;
    }
}
