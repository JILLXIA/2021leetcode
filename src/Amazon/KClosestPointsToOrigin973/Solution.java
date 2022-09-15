package Amazon.KClosestPointsToOrigin973;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of points where points[i] = [xi, yi]
 * represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean
 * distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 */
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare(checkDistance(o2[0],o2[1]),checkDistance(o1[0],o1[1]));
            }
        });
        for(int i = 0;i<points.length;i++){
            if(pq.size() < k){
                pq.add(points[i]);
            } else {
                if(checkDistance(points[i][0],points[i][1]) < checkDistance(pq.peek()[0],pq.peek()[1])){
                    pq.poll();
                    pq.add(points[i]);
                }
            }
        }
        int[][] result = new int[pq.size()][2];
        int index = 0;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            result[index] = tmp;
            index++;
        }
        return result;

    }

    public double checkDistance(int x, int y){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }
}
