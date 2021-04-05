package 数组.统计参与通信的服务器1267;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在m * n的整数矩阵网格grid中，
 * 1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 */

/**
 * 先遍历一次计算每行每列的数量
 */
public class Solution {
    public int countServers(int[][] grid) {
        int[] arr1 = new int[grid.length];
        int[] arr2 = new int[grid[0].length];
        for(int i = 0;i< grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    arr1[i]++;
                    arr2[j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0;i< grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1&&arr1[i]+arr2[j]-2>0){
                    count++;
                }
            }
        }
        return count;
    }
}
