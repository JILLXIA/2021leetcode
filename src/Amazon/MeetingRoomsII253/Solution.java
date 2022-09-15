package Amazon.MeetingRoomsII253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 */
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0] - o2[0];
            }
        });
        // 记录endTime, 小顶堆，记录最小endTime
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1;i<intervals.length;i++){
            if(pq.peek() < intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minMeetingRooms(new int[][]{{7,10},{2,4}}));
    }
}
