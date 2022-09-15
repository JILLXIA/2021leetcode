package Amazon.MeetingRooms252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
 * determine if a person could attend all meetings.
 */
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0){
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int endTime = intervals[0][1];
        for(int i = 1;i< intervals.length;i++){
            if(endTime > intervals[i][0]){
                return false;
            }
            endTime = intervals[i][1];
        }
        return true;
    }
}
