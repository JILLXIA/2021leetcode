package 图.ShortestBridge934;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    Deque<Point> dequeEdge = new LinkedList<Point>();
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || grid[i][j]==0 || grid[i][j]==2){
            return ;
        }
        dequeEdge.offerLast(new Point(i,j));
        grid[i][j] = 2;
        for(int k = 0;k<4;k++){
            dfs(grid,i+dirs[k][0],j+dirs[k][1]);
        }
    }
    public int shortestBridge(int[][] grid) {
        // BFS
        // find one of the island
        int n = grid.length;
        OUT:
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
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
        Solution1 s = new Solution1();
        System.out.println(s.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
    }
}

