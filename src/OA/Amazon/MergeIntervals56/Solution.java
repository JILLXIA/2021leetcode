package OA.Amazon.MergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o2[1] - o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]> delOverlap = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1;i< intervals.length;i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            } else {
                delOverlap.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        delOverlap.add(new int[]{start,end});
        int[][] result = new int[delOverlap.size()][2];
        for(int i = 0;i< result.length;i++){
            result[i][0] = delOverlap.get(i)[0];
            result[i][1] = delOverlap.get(i)[1];
        }
        return result;
    }
}
