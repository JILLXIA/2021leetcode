package 动态规划.动态规划21天初级.第二天.爬楼梯70;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Solution {
    public int climbStairs(int n) {
        int num1  = 1;
        int num2  = 2;
        if(n<=2){
            return n;
        }
        int result = 0;
        for(int i = 3;i<=n;i++){
            result = num1+num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }
}
