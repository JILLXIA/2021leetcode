package Amazon.TrappingRainWater42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given n non-negative integers representing an elevation
 * map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class Solution {
    public int trap(int[] height) {
        int[] leftBigger = new int[height.length+1];
        int[] rightBigger = new int[height.length+1];

        for(int i = 1;i<leftBigger.length;i++){
            leftBigger[i] = Math.max(leftBigger[i-1],height[i-1]);
            rightBigger[height.length - i] = Math.max(rightBigger[height.length - i+1],height[height.length - i]);
        }

        int result = 0;
        for(int i = 0;i<height.length;i++){
            result += Math.min(leftBigger[i+1],rightBigger[i]) - height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
