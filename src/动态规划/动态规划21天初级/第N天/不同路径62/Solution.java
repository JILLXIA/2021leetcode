package 动态规划.动态规划21天初级.第N天.不同路径62;

/**
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;
        for(int i = n; i<= m+n-2;i++){
            result = result * i/(i-n+1);
        }
        return (int)(result);
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.uniquePaths(23,12));
    }
}
