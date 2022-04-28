package 贪心算法.VideoStitching1024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a series of video clips from a sporting event that
 * lasted time seconds. These video clips can be overlapping with each
 * other and have varying lengths.
 *
 * Each video clip is described by an array clips where clips[i] = [starti, endi] indicates that the ith clip started at starti and ended at endi.
 *
 * We can cut these clips into segments freely.
 *
 * For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
 * Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event [0, time]. If the task is impossible, return -1.
 */
public class Solution {
	public int videoStitching(int[][] clips, int time) {
		Arrays.sort(clips, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]){
					return o2[1] - o1[1];
				}else{
					return o1[0]-o2[0];
				}
			}
		});

		if(clips[0][0] != 0){
			return -1;
		}

		int x_end = clips[0][1];
		int result = 1;

		int index = 1;
		while(index<clips.length){
			if(x_end >= time){
				return result;
			}
			int curr_end = x_end;
			while(index< clips.length && clips[index][0] <= curr_end){
				x_end = Math.max(x_end,clips[index][1]);
				index++;
			}
			if(index >= clips.length || clips[index][0] < x_end){
				result++;
			} else {
				return -1;
			}
		}
		return x_end >= time ? result : -1;
	}
	public static void main(String[] args){
		Solution s = new Solution();
		s.videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}},10);
	}
}
