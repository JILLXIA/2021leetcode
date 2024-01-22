package Grind75.ClimbingStairs70;

/**
 * You are climbing a staircase.
 * It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class Solution {
    public int climbStairs_old(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        } else {
            return climbStairs_old(n-1) + climbStairs_old(n - 2);
        }
    }

    public int climbStairs(int n) {
        int nMinus1 = 1;
        int nMinus2 = 2;
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        int tmp = 0;
        for(int i = 3; i <= n; i++) {
            tmp = nMinus1 + nMinus2;
            nMinus1 = nMinus2;
            nMinus2 = tmp;
        }
        return tmp;
    }
}
