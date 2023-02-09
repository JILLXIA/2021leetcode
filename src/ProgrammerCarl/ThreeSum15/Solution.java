package ProgrammerCarl.ThreeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i < nums.length - 1;i++){
            List<List<Integer>> twoTmp = twoSum(nums, -nums[i], i+1);
            if(i != 0 && nums[i]== nums[i-1]){
                continue;
            }
            for(List<Integer> eachTmp: twoTmp){
                List<Integer> tmp = new ArrayList<>(eachTmp);
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> result = new ArrayList<>();

        int left = start;
        int right = nums.length - 1;

        while(left < right){
            // cannot be equal
            int sum = nums[left] + nums[right];
            int preLeft = left;
            int preRight = right;
            while(sum < target && (left < right && nums[left]==nums[preLeft])){
                left++;
            }

            while(sum > target && (left < right && nums[right]==nums[preRight])){
                right--;
            }

            if(sum == target){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                result.add(tmp);
                while(left < right && nums[left]==nums[preLeft]){
                    left++;
                }

                while(left < right && nums[right]==nums[preRight]){
                    right--;
                }
            }
        }
        return result;
    }
}
