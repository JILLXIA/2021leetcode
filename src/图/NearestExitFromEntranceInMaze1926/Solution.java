package 图.NearestExitFromEntranceInMaze1926;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells
 * (represented as '.') and walls (represented as '+').
 * You are also given the entrance of the maze,
 * where entrance = [entrancerow, entrancecol]
 * denotes the row and column of the cell you are initially standing at.
 *
 * In one step, you can move one cell up, down, left, or right.
 * You cannot step into a cell with a wall,
 * and you cannot step outside the maze.
 * Your goal is to find the nearest exit from the entrance.
 * An exit is defined as an empty cell that is at the border of the maze.
 * The entrance does not count as an exit.
 *
 * Return the number of steps in the shortest path from the
 * entrance to the nearest exit, or -1 if no such path exists.
 */
public class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        // BFS
        Deque<Point> deque = new LinkedList<Point>();
        deque.offerLast(new Point(entrance[0],entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';
        int step = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            step++;
            while(!deque.isEmpty() && size > 0){
                Point tmp = deque.pollFirst();
                for(int i = 0;i<dirs.length;i++){
                    int nextX = tmp.x + dirs[i][0];
                    int nextY = tmp.y + dirs[i][1];
                    if(nextX>=0 && nextY>=0 && nextX< maze.length
                            && nextY<maze[0].length && maze[nextX][nextY]=='.'){
                        // next cell is within the boundary; also is not a wall
                        if(nextX * nextY * (nextX - maze.length + 1) * (nextY - maze[0].length+1) == 0){
                            return step;
                        } else {
                            deque.offerLast(new Point(nextX,nextY));
                            maze[nextX][nextY] = '+';
                        }
                    }
                }
                size--;
            }
        }
        return -1;
    }
}

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}