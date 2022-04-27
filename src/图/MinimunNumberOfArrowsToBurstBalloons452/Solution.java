package 图.MinimunNumberOfArrowsToBurstBalloons452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where
 * points[i] = [xstart, xend] denotes a balloon whose horizontal diameter
 * stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction)
 * from different points along the x-axis. A balloon with xstart and xend
 * is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *
 * Given the array points, return the minimum number of arrows that
 * must be shot to burst all balloons.
 */
public class Solution {
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]<o2[1]){
					return -1;
				} else if(o1[1]>o2[1]){
					return 1;
				}
				return 0;
			}
		});

		int[] start = new int[points.length];
		int[] end = new int[points.length];

		for(int i = 0;i< points.length;i++){
			start[i] = points[i][0];
			end[i] = points[i][1];
		}
		int i = 0;
		int j = 0;
		int count = 0;
		while(i< points.length && j< points.length){
			int countIndex = 0;
			while(i< points.length && start[i] <= end[j]){
				i++;
				countIndex++;
			}
			j += countIndex;
			count++;
		}
		return count;
	}
}
