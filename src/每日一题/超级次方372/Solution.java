package 每日一题.超级次方372;

/**
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，
 * b 是一个非常大的正整数且会以数组形式给出。
 */
public class Solution {
    // 啥也不会 直接抄答案的
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int e : b) {
            ans = (int) ((long) pow(ans, 10) * pow(a, e) % MOD);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }
}
