package 图.MinimunNumberOfArrowsToBurstBalloons452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
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

		int start = points[0][0];
		int x_end = points[0][1];
		int count = 0;

		for(int[] arr:points){
			start = arr[0];
			if(start > x_end){
				x_end = arr[1];
				count++;
			}
		}

		return count;
	}
}
