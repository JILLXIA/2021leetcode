package Google.MinimumTimeDifference539;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of 24-hour clock time points in "HH:MM" format,
 * return the minimum minutes difference between any two time-points in the list.
 */
public class Solution {
    // 直接一次parse好成int不行吗？？
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] sArr1 = o1.split(":");
                String[] sArr2 = o2.split(":");
                int hour1 = Integer.parseInt(sArr1[0]);
                int hour2 = Integer.parseInt(sArr2[0]);
                int minute1 = Integer.parseInt(sArr1[1]);
                int minute2 = Integer.parseInt(sArr2[1]);
                if(hour1==hour2){
                    return minute1 - minute2;
                }
                return hour1-hour2;
            }
        });
        int result = Integer.MAX_VALUE;
        for(int i = 0;i<timePoints.size();i++){
            String[] time1 = timePoints.get(i).split(":");
            String[] time2 = i + 1 == timePoints.size() ? timePoints.get(0).split(":"): timePoints.get(i+1).split(":");
            result = Math.min(result,checkTime(Integer.parseInt(time1[0]),Integer.parseInt(time1[1]),
                    i + 1== timePoints.size() ?Integer.parseInt(time2[0])+24:Integer.parseInt(time2[0]),Integer.parseInt(time2[1])));
        }
        return result;
    }

    public int checkTime(int hour1, int minute1, int hour2, int minute2){
        return (hour2-hour1) * 60 + (minute2 - minute1);
    }
}
