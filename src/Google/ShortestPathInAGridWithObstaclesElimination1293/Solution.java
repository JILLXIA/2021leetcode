package Google.ShortestPathInAGridWithObstaclesElimination1293;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an m x n integer matrix grid
 * where each cell is either 0 (empty) or 1 (obstacle).
 * You can move up, down, left, or right
 * from and to an empty cell in one step.
 *
 * Return the minimum number of steps to walk from the upper
 * left corner (0, 0) to the lower right corner (m - 1, n - 1)
 * given that you can eliminate at most k obstacles.
 * If it is not possible to find such walk return -1.
 */
public class Solution {
    // 求最短路径想到用bfs
    public int shortestPath(int[][] grid, int k) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(new int[]{0,0,0});// 第三个参数是消除方块的次数
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int n = grid.length;
        int m = grid[0].length;
        int step = 0;
        //which is the number of obstacles we can eliminate when we start at cell
        boolean[][][] isVisited = new boolean[n][m][k+1];// 第三位表示这是冲破的第几个
        isVisited[0][0][0] = true;
        while(!deque.isEmpty()){
            int size = deque.size();
            while(!deque.isEmpty() && size > 0){
                int[] tmp = deque.pollFirst();
                if(tmp[0]==n-1 && tmp[1]==m-1){
                    return step;
                }
                for(int i = 0;i< dirs.length;i++){
                    if(tmp[0] + dirs[i][0] < 0 || tmp[0] + dirs[i][0] >= n
                    || tmp[1] + dirs[i][1] < 0 || tmp[1] + dirs[i][1] >= m){
                        continue;
                    }
                    if(grid[tmp[0] + dirs[i][0]][tmp[1] + dirs[i][1]]==0){
                        if(!isVisited[tmp[0] + dirs[i][0]][tmp[1] + dirs[i][1]][tmp[2]]) {
                            isVisited[tmp[0] + dirs[i][0]][tmp[1] + dirs[i][1]][tmp[2]] = true;
                            deque.offerLast(new int[]{tmp[0] + dirs[i][0], tmp[1] + dirs[i][1], tmp[2]});
                        }
                    } else {
                        if(tmp[2] >= k){
                            continue;
                        } else {
                            if(!isVisited[tmp[0] + dirs[i][0]][tmp[1] + dirs[i][1]][tmp[2]+1]) {
                                isVisited[tmp[0] + dirs[i][0]][tmp[1] + dirs[i][1]][tmp[2]+1] = true;
                                deque.offerLast(new int[]{tmp[0] + dirs[i][0], tmp[1] + dirs[i][1], tmp[2] + 1});
                            }
                        }
                    }
                }
                size--;
            }
            step++;
        }
        return -1;
    }
}
