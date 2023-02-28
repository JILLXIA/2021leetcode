package ProgrammerCarl.FourSum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, (long)target, 0, 4);
    }

    public List<List<Integer>> nSum(int[] nums, long target, int start, int n) {
        if(n == 2){
            return twoSum(nums, target, start);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = start; i < nums.length - n + +1;i++){
            if(i != start && nums[i]==nums[i-1]){
                continue;
            }
            List<List<Integer>> tmp = nSum(nums, target - nums[i], i + 1, n-1);
            for(List<Integer> each : tmp){
                List<Integer> eachResult = new ArrayList<>(each);
                eachResult.add(nums[i]);
                result.add(eachResult);
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start){
        List<List<Integer>> result = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;

        while(left < right){
            long sum = (long)(nums[left] + nums[right]);
            int preLeft = left;
            int preRight = right;
            while(sum < target && left < right && nums[left] == nums[preLeft]){
                left++;
            }

            while(sum > target && left < right && nums[right] == nums[preRight]){
                right--;
            }

            if(sum == target){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                result.add(tmp);
                while(left < right && nums[left] == nums[preLeft]){
                    left++;
                }
                while(left < right && nums[right] == nums[preRight]){
                    right--;
                }

            }
        }
        return result;
    }
}
