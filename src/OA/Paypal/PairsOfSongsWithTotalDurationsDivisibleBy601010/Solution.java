package OA.Paypal.PairsOfSongsWithTotalDurationsDivisibleBy601010;

import java.util.HashMap;

/**
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i,
 * j such that i < j with (time[i] + time[j]) % 60 == 0.
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap(); // remainder TO count
        int result = 0;
        for(int i = 0;i<time.length;i++){
            int curTime = time[i] % 60;
            // int needTime = curTime == 0? 0: (60 - curTime);
            if(map.containsKey((60 - curTime)%60)){
                result += map.get((60 - curTime)%60);
            }
            map.put(curTime, map.getOrDefault(curTime, 0)+1);
        }
        return result;
    }
}
