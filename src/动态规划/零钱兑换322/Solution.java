package 动态规划.零钱兑换322;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 你可以认为每种硬币的数量是无限的。
 */

/**
 * 求最值的问题，所需最少硬币的问题
 * 状态：目标金额amount 会变化的
 * 选择：coins，数组中列出的所有硬币面额
 * 函数的定义：凑出总金额amount，至少需要coinChange(coins,amount)个硬币
 * base case：amount==0 时，需要0个硬币，amount<0时，不可能凑出
 *
 * 画树状图
 *
 * coinChange([1,2,5],11) = 1 + min(coinChange([1,2,5],10),
 * coinChange([1,2,5],9),coinChange([1,2,5],6))
 */

/**
 * 这样会有重复计算，会超时
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }

        int res = Integer.MAX_VALUE;

        for(int coin:coins){
            int tmp = coinChange(coins,amount-coin);
            if(tmp==-1){
                continue;
            }
            res = Math.min(res,tmp);
        }
        if(res==Integer.MAX_VALUE){
            return -1;
        }else{
            return res+1;
        }
    }
}
