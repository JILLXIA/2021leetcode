package ByteDance.WallsAndGates286;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room.
 * We use the value 231 - 1 = 2147483647 to represent INF
 * as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Deque<int[]> deque = new LinkedList<>(); // 0:y; 1:x; 2:distance

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(rooms[i][j]==0){
                    deque.offerLast(new int[]{i,j,0});
                }
            }
        }

        // isVisited要在进入队列的时候就执行

        while(!deque.isEmpty()){
            int[] tmp = deque.pollFirst();
            for(int i = 0;i<dirs.length;i++){
                int nexty = tmp[0] + dirs[i][0];
                int nextx = tmp[1] + dirs[i][1];
                if(nexty < 0 || nexty >= m || nextx < 0 || nextx >= n || rooms[nexty][nextx]!= Integer.MAX_VALUE){
                    continue;
                }
                rooms[nexty][nextx] = tmp[2]+1;
                deque.offerLast(new int[]{nexty, nextx,tmp[2] + 1});
            }
        }
    }
}
