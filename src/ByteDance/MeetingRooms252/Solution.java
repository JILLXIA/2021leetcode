package ByteDance.MeetingRooms252;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi],
 * determine if a person could attend all meetings.
 */
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        if(intervals.length==0){
            return true;
        }

        int endTime = intervals[0][1];
        for(int i = 0;i<intervals.length-1;i++){
            if(intervals[i+1][0] >= endTime){
                endTime = intervals[i+1][1];
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
