package Grind75.PlatesBetweenCandles2055;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        // record all the candles index
        List<Integer> candleIndex = new ArrayList<>();
        // presum
        // int[] preSum_new = new int[s.length()+1];
        List<Integer> preSum = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                sum++;
                // preSum_new[i+1] = preSum_new[i]+1;
            } else {
                preSum.add(sum);
                // preSum_new[i+1] = preSum_new[i];
                candleIndex.add(i);
            }
        }
        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            int leftIndex = 0;
            int rightIndex = candleIndex.size();
            while(leftIndex < rightIndex) {
                int mid = leftIndex + (rightIndex - leftIndex) / 2;
                if(candleIndex.get(mid) >= left) {
                    rightIndex = mid;
                } else if(candleIndex.get(mid) < left) {
                    leftIndex = mid + 1;
                }
            }

            left = leftIndex;

            leftIndex = 0;
            rightIndex = candleIndex.size();
            while(leftIndex < rightIndex) {
                int mid = leftIndex + (rightIndex - leftIndex) / 2;
                if(candleIndex.get(mid) > right) {
                    rightIndex = mid;
                } else if(candleIndex.get(mid) <= right) {
                    leftIndex = mid + 1;
                }
            }
            right = leftIndex - 1;

            if(right > left) {
                result[i] = preSum.get(right) - preSum.get(left);
                // result[i] = preSum_new[right + 1] - preSum_new[left + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] query = new int[][]{{2,5},{5,9}};
        s.platesBetweenCandles("**|**|***|", query);

    }
}
