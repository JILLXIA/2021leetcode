package 每日一题.省份数量547;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
 * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，
 * 其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        // 图怎么使用dfs呢？
        // 不需要回溯
        boolean[] isVisited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0;i< isVisited.length;i++){
            if(!isVisited[i]){
                count++;
                dfs(i,isConnected,isVisited);
            }
        }
        return count;
    }

    public void dfs(int i,int[][] isConnected, boolean[] isVisited){
        isVisited[i] = true;
        for(int j = 0;j< isVisited.length;j++){
            if(isConnected[i][j] == 1 && !isVisited[j]){
                dfs(j,isConnected,isVisited);
            }
        }
    }
}
