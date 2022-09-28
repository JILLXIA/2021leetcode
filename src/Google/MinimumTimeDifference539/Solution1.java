package Google.MinimumTimeDifference539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for(int i = 0;i<timePoints.size();i++){
            String[] sArr = timePoints.get(i).split(":");
            arr[i] = Integer.parseInt(sArr[0]) * 60 + Integer.parseInt(sArr[1]);
        }
        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length;i++){
            int countTime = i!=arr.length-1 ? arr[i+1]-arr[i]:arr[0] + 24 * 60-arr[i];
            result = Math.min(countTime,result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        List<String> tmp = new ArrayList<>();
        tmp.add("23:59");
        tmp.add("00:00");
        System.out.println(s.findMinDifference(tmp));
    }
}
