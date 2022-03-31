package 图.AsFarFromLandAsPossible1162;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an n x n grid containing only values 0 and 1, 
 * where 0 represents water and 1 represents land, 
 * find a water cell such that its distance to the nearest 
 * land cell is maximized, and return the distance. 
 * If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: 
the distance between two cells (x0, y0) and (x1, y1) 
is |x0 - x1| + |y0 - y1|.
 */
/**
 * We mark water cells as visited and continue the expansion 
 * from land cells until there are no more water cells left. 
 * In the end, the number of steps in BFS is how far 
 * can we go from the land.
 */
// Runtime: O(n * n). We process an individual cell only once (or twice).
public class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int maxDistance(int[][] grid) {
        Deque<Point> deque = new LinkedList<Point>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    deque.offerLast(new Point(i,j));
                }
            }
        }
        int count = 1;
        while(!deque.isEmpty()){
            count++;
            int size = deque.size();
            while(!deque.isEmpty() && size>0){
                Point tmp = deque.pollFirst(); // get the first cell in the deque
                for(int i = 0;i<dirs.length;i++){
                    int tmpx = tmp.x + dirs[i][0];
                    int tmpy = tmp.y + dirs[i][1];
                    if(tmpx>=0&&tmpy>=0&&tmpx<grid.length&&tmpy<grid[0].length && grid[tmpx][tmpy]==0){
                        deque.offerLast(new Point(tmpx,tmpy));
                        grid[tmpx][tmpy] = count;
                    }
                }
                
                size--;
            }
        }
        return count-2 == 0?-1:count-2;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        s.maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}});
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
