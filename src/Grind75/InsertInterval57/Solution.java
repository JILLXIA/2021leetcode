package Grind75.InsertInterval57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals
 * where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and
 * intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end]
 * that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals
 * is still sorted in ascending order by starti and intervals
 * still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 1. find intervals which end >= newInterval[start]
        // 2. newInterval[end] compare with start, if > move next, if < , Math.max(previous last,end)
        List<int[]> aggregateList = new ArrayList<>();

        int index = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        boolean hasAdd = false;
        while(index < intervals.length) {
            if(intervals[index][1] < newInterval[0]){
                aggregateList.add(intervals[index]);
            } else if(intervals[index][0] > newInterval[1]) {
                if(!hasAdd){
                    aggregateList.add(new int[]{start, end});
                }
                hasAdd = true;
                aggregateList.add(intervals[index]);
            } else {
                start = Math.min(start, Math.min(intervals[index][0], newInterval[0]));
                end = Math.max(end, Math.max(intervals[index][1], newInterval[1]));
            }
            index++;
        }
        if(!hasAdd) {
            aggregateList.add(new int[]{start, end});
        }

        int[][] result = new int[aggregateList.size()][2];
        for(int i = 0; i < result.length;i++) {
            result[i] = new int[2];
            result[i][0] = aggregateList.get(i)[0];
            result[i][1] = aggregateList.get(i)[1];
        }
        return result;
    }
}
