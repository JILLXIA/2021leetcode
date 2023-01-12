package Grind75.FloodFill733;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 *
 * Return the modified image after performing the flood fill.
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int source, int target){
        if(source==target){
            return ;
        }
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != source){
            return;
        }

        image[i][j] = target;

        dfs(image, i+1, j, source, target);
        dfs(image, i-1, j, source, target);
        dfs(image, i, j+1, source, target);
        dfs(image, i, j-1, source, target);
    }
}
