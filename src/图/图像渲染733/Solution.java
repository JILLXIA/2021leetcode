package 图.图像渲染733;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。

给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。

为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。

最后返回经过上色渲染后的图像。
 */
public class Solution {
    public int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Deque<Point> deque = new LinkedList<Point>();
        boolean[][] isVisited = new boolean[image.length][image[0].length];
        int value = image[sr][sc];
        isVisited[sr][sc] = true;
        deque.offerLast(new Point(sr,sc));

        while(deque.size()!=0){
            Point tmp = deque.pollFirst();
            image[tmp.x][tmp.y] = newColor;
            for(int i = 0;i<4;i++){
                int tmpSr = tmp.x+dir[i][0];
                int tmpSc = tmp.y+dir[i][1];
                if(tmpSr>=0&&tmpSr<image.length&&tmpSc>=0&&tmpSc<image[0].length){
                    // 没有越界的情况
                    if(!isVisited[tmpSr][tmpSc]){
                        // 没有访问到的情况
                        if(value == image[tmpSr][tmpSc]){
                            deque.offerLast(new Point(tmpSr,tmpSc));
                        }
                        isVisited[tmpSr][tmpSc] = true;
                    }
                    
                }
            }
        }
        return image;
    }

    // O(m*n)
    public static void main(String[] args){
        Solution s = new Solution();
        s.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
    }
    
}

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}