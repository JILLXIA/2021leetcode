package 每日一题.救生艇881;

/**
 * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 */

import java.util.Arrays;

/**
 * OMG 第一眼想到的居然是背包问题，可是这道题应该用贪心+左右指针；
 * 先排序，判断最轻的人能不能和最终的人一条船
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int count = 0;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}
