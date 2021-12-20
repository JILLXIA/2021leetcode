package 每日一题.供暖器475;

import java.util.Arrays;

/**
 * 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋houses 和供暖器heaters 的位置，
 * 请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        int index = 0;

        Arrays.sort(houses);
        Arrays.sort(heaters);
        for(int i = 0;i<houses.length;i++){
            while(index<heaters.length-1 && houses[i]>heaters[index]){
                index++;
            }
            int preIndex = index == 0 ? 0 : index - 1;
            int tmp = Math.min(Math.abs(houses[i]-heaters[index]),Math.abs(houses[i]-heaters[preIndex]));
            result = Math.max(tmp,result);
        }
        return result;
    }
}
