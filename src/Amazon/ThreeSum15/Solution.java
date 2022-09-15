package Amazon.ThreeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an integer array nums,
 * return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<nums.length-2;i++){
            if(!set.contains(nums[i])){
                List<List<Integer>> twoSumlist = twoSum(nums, -nums[i], i+1);
                for(List<Integer> twoItem:twoSumlist){
                    List<Integer> tmpResult = new ArrayList<>(twoItem);
                    tmpResult.add(0,nums[i]);
                    result.add(tmpResult);
                }
            }
            set.add(nums[i]);
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        int left = start;
        int right = nums.length-1;
        List<List<Integer>> result = new ArrayList<>();
        int sum  = 0;
        while(left < right){
            sum = nums[left] + nums[right];
            int preLeft = left;
            int preRight = right;
            while(sum < target && left < right && nums[left] == nums[preLeft]){
                left++;
            }

            while(sum > target && left < right && nums[right]==nums[preRight]){
                right--;
            }
            if(sum==target){
                ArrayList<Integer> tmp = new ArrayList();
                tmp.add(nums[left]);
                tmp.add(nums[right]);
                result.add(tmp);
                while(left < right&& nums[left]==nums[preLeft]){
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
