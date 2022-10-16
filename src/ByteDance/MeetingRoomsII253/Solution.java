package ByteDance.MeetingRoomsII253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 */
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0;i<intervals.length;i++){
            if(pq.isEmpty() || pq.peek() > intervals[i][0]){
                pq.add(intervals[i][1]);
            } else {
                pq.poll();
                pq.add(intervals[i][1]);
            }
        }
        return pq.size();

    }
}
