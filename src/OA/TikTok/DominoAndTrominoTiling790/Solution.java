package OA.TikTok.DominoAndTrominoTiling790;

/**
 * You have two types of tiles: a 2 x 1 domino shape and a tromino shape.
 * You may rotate these shapes.
 *
 * Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
 *
 * In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally
 * adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
 */
public class Solution {
    // 用一个二维数组来解题
    // dp[i][0] --全部沾满的时候
    // dp[i][1] --部分沾满的时候
    // 花花酱：https://www.youtube.com/watch?v=S-fUTfqrdq8
    public int numTilings(int n) {
        long[][] dp = new long[n+1][2];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i = 2;i<dp.length;i++){
            dp[i][0] = (long) ((dp[i-1][0] + dp[i-2][0] + dp[i-1][1] * 2)%(1e9+7));
            dp[i][1] = (long) (dp[i-1][1] + dp[i-2][0] % (1e9+7));
        }
        return (int) (dp[n][0]%(1e9+7));
    }
}
