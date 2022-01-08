package 动态规划.动态规划21天初级.第一天.斐波那契数509;

/**
 * 斐波那契数，通常用F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 */
public class Solution {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        if(n<=1){
            return n;
        }
        int c = 0;
        for(int i = 2;i<=n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
