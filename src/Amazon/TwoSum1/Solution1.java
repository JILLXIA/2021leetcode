package Amazon.TwoSum1;

import java.util.Arrays;

public class Solution1 {
    // 由于这道题是返回索引，所以排序玩之后还要一个map映射
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int sum = nums[left] + nums[right];
        int[] result = new int[2];
        while(left < right){
            sum = nums[left] + nums[right];
            if(sum > target){
                right--;
            } else if(sum < target){
                left++;
            } else {
                result[0] = left;
                result[1] = right;
                return result;
            }
        }
        return result;
    }
}
