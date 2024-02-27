package Leetcode75.CanPlaceFlowers605;

/**
 * You have a long flowerbed in which some of the plots are planted,
 * and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's,
 * where 0 means empty and 1 means not empty,
 * and an integer n, return true if n new flowers can be
 * planted in the flowerbed without violating the
 * no-adjacent-flowers rule and false otherwise.
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // need to check a point left side and right side
        int maxCount = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            int leftSide = i == 0 ? 0 : flowerbed[i-1];
            int rightSide = i == flowerbed.length - 1 ? 0 : flowerbed[i+1];

            if(flowerbed[i] == 0 && leftSide + rightSide == 0) {
                flowerbed[i] = 1;
                maxCount++;
            }
        }
        return maxCount >= n;
    }
}
