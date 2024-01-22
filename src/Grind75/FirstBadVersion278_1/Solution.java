package Grind75.FirstBadVersion278_1;

public class Solution {
    public int firstBadVersion(int n) {
        // binary search
        int left = 1;
        int right = n;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int mid){
        return true;
    }
}
