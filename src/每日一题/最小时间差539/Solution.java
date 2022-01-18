package 每日一题.最小时间差539;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 也可以通过TreeSet达到排序的目的
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<int[]> arr = new ArrayList<>();
        for(int i = 0;i<timePoints.size();i++){
            String[] s = timePoints.get(i).split(":");
            arr.add(new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])});
        }
        arr.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*60 + o1[1]- o2[0]*60-o2[1];
            }
        });

        arr.add(new int[]{arr.get(0)[0]+24,arr.get(0)[1]});

        int result = Integer.MAX_VALUE;
        for(int i = 1;i<arr.size();i++){
            result = Math.min(result,cal(arr.get(i-1),arr.get(i)));
            if(result==0){
                return result;
            }
        }
        return result;
    }

    public int cal(int[] o1,int[] o2){
        return (o2[0]-o1[0])*60 + (o2[1]-o1[1]);
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<String> ss = new ArrayList<>();
        ss.add("23:59");
        ss.add("00:00");
        s.findMinDifference(ss);
    }
}
