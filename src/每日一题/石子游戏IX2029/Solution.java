package 每日一题.石子游戏IX2029;

/**
 * Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，
 * 每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，
 * 其中 stones[i] 是第 i 个石子的价值。
 *
 * Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones中移除任一石子。
 *
 * 如果玩家移除石子后，导致 所有已移除石子 的价值总和 可以被 3 整除，那么该玩家就 输掉游戏 。
 * 如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
 * 假设两位玩家均采用最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。
 */
public class Solution {
    // 博弈论 没啥意义，当作脑经急转弯
    public boolean stoneGameIX(int[] stones) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        for(int i = 0;i<stones.length;i++){
            switch (stones[i]%3){
                case 0:
                    num3++;
                    break;
                case 1:
                    num1++;
                    break;
                case 2:
                    num2++;
                    break;
            }
        }

        int n = Math.abs(num2-num1) % 3;
        return num3%2==0?!(num1 == 0 || num2 == 0) : !(Math.abs(num1 - num2) <= 2);
    }
}
