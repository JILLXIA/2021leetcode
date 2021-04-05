package 数组.三角形最小路径和120;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点
 * 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */

/**
 * 动态规划问题要留意边界状态
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] dp = triangle.get(length-1).stream().mapToInt(Integer::intValue).toArray();//List转化为数组
        for(int i = length-2;i>=0;i--){
            int tempLength = triangle.get(i).size();
            for(int j = 0;j<tempLength;j++){
                int temp = triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
                dp[j] = temp;
            }

        }
        return dp[0];
    }
}
