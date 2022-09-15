package Amazon.FourSum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array nums of n integers,
 * return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0;i<nums.length-3;i++){
            if(!set.contains(nums[i])){
                List<List<Integer>> threeList = threeSum(nums,i+1,target - nums[i]);
                for(List<Integer> threeItem:threeList){
                    List<Integer> tmp = new ArrayList<>(threeItem);
                    tmp.add(0,nums[i]);
                    result.add(tmp);
                }
            }
            set.add(nums[i]);
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, long target) {
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = start;i<nums.length-2;i++){
            if(!set.contains(nums[i])){
                List<List<Integer>> twoSumlist = twoSum(nums, target-nums[i], i+1);
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

    public List<List<Integer>> twoSum(int[] nums, long target, int start){
        int left = start;
        int right = nums.length-1;
        List<List<Integer>> result = new ArrayList<>();
        long sum  = 0;
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
