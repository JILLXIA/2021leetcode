package 图.ShortestBridge934;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an n x n binary matrix grid where 1 represents
 * land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's
 * not connected to any other 1's. There are exactly two islands
 * in grid.
 *
 * You may change 0's to 1's to connect the two islands to
 * form one island.
 *
 * Return the smallest number of 0's you must flip to
 * connect the two islands.
 */

// exceed the time limit,we should use DFS to find the first island
public class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        // BFS
        // find one of the island
        Deque<Point> deque = new LinkedList<Point>();
        Deque<Point> dequeEdge = new LinkedList<Point>();
        int n = grid.length;
        OUT:
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==1){
                    // find one land cell in one of the island
                    deque.offerLast(new Point(i,j));
                    // use BFS to find one of the island, tansfer the 1s in that islands to 2s
                    while(!deque.isEmpty()){
                        Point tmp = deque.pollFirst();
                        grid[tmp.x][tmp.y] = 2;
                        int count = 0;
                        for(int k = 0;k<4;k++){
                            int nextX = tmp.x+dirs[k][0];
                            int nextY = tmp.y+dirs[k][1];
                            if(nextX>=0&&nextX<n&&nextY>=0&&nextY<n){
                                if(grid[nextX][nextY]==1) {
                                    deque.offerLast(new Point(nextX, nextY));
                                } else{
                                    // the land cell(tmp.x,tmp.y) is at the edge of the island
                                    count++;
                                }
                            }
                        }
                        if(count!=0){
                            dequeEdge.offerLast(tmp);
                        }
                    }
                    break OUT;
                }
            }
        }

        int step = 2;
        while(!dequeEdge.isEmpty()){
            step++;
            int size = dequeEdge.size();
            while(!dequeEdge.isEmpty() && size>0){
                Point point = dequeEdge.pollFirst();
                for(int k = 0;k<4;k++) {
                    int nextX = point.x+dirs[k][0];
                    int nextY = point.y+dirs[k][1];
                    if(nextX>=0&&nextX<n&&nextY>=0&&nextY<n){
                        if(grid[nextX][nextY]==0) {
                            grid[nextX][nextY] = step;
                            dequeEdge.offerLast(new Point(nextX, nextY));
                        } else if(grid[nextX][nextY]==1){
                            // find the 2nd bridge
                            return step - 3;
                        }
                    }
                }
                size--;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.shortestBridge(new int[][]{{0,1},{1,0}}));
    }
}

class Point {
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}