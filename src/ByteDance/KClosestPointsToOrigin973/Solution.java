package ByteDance.KClosestPointsToOrigin973;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of points where points[i] = [xi, yi]
 * represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the
 * Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 */
public class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return dist(o1[0],o1[1]) - dist(o2[0],o2[1]);
            }
        });
        int[][] result = Arrays.copyOfRange(points, 0, k);
        return result;
    }

    public int dist(int x, int y){
        return x * x + y * y;
    }
}
