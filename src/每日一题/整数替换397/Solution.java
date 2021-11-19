package 每日一题.整数替换397;

/**
 * 给定一个正整数n ，你可以做如下操作：
 *
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * n变为 1 所需的最小替换次数是多少？
 */
public class Solution {
    public int integerReplacement(int n) {
        // 尽量减少奇数替换
        int count = 0;
        /**
         * 单独考虑等于最大值的情况
         */
        if(n==Integer.MAX_VALUE){
            return 32;
        }
        while(n!=1){
            if((n & 1) == 1){
                // 奇数
                n = ((n & 3) == 3 && n!=3 ) ? n+1 :n-1;
            }else {
                n = n >> 1;
            }
            count++;
        }
        return count;
    }
}
