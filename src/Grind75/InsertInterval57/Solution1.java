package Grind75.InsertInterval57;

import java.util.ArrayList;
import java.util.List;
// make the code clean and readable
public class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> aggregateList = new ArrayList<>();

        int index = 0;
        int start = newInterval[0];
        int end = newInterval[1];

        while(index < intervals.length && intervals[index][1] < newInterval[0]) {
            aggregateList.add(intervals[index]);
            index++;
        }

        while(index < intervals.length && intervals[index][0] <= newInterval[1]) {
            start = Math.min(start, Math.min(newInterval[0], intervals[index][0]));
            end = Math.max(end, Math.max(newInterval[1], intervals[index][1]));
            index++;
        }

        aggregateList.add(new int[]{start, end});

        while(index < intervals.length) {
            aggregateList.add(intervals[index]);
            index++;
        }

        int[][] result = new int[aggregateList.size()][2];
        for(int i = 0; i < result.length;i++) {
            result[i] = new int[2];
            result[i][0] = aggregateList.get(i)[0];
            result[i][1] = aggregateList.get(i)[1];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
    }
}
