package labuladong.CarPooling1094;

public class Solution1 {
    // difference array
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for(int[] trip:trips){
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int max = -1;
        int pre = 0;
        for(int i = 0;i< diff.length;i++){
            max = Math.max(max, diff[i] + pre);
            pre = diff[i] + pre;
            if(max > capacity){
                return false;
            }
        }
        return true;
    }
}
