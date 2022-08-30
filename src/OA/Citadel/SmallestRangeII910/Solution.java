package OA.Citadel.SmallestRangeII910;

import java.util.Arrays;

public class Solution {
    public int smallestRangeII(int[] nums, int k) {
        // sort
        Arrays.sort(nums);
        // 找中点
        // 任何一个点都可以是分界点
        int boundryMax = nums[nums.length-1] - k;
        int boundryMin = nums[0] + k;
        int answer = nums[nums.length-1] - nums[0];

        for(int i = 0;i<nums.length-1;i++){
            int min = Math.min(boundryMin,nums[i+1]-k);
            int max = Math.max(boundryMax,nums[i] + k);
            answer = Math.min(answer,max-min);
        }
        return answer;
    }
}
