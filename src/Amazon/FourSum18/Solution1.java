package Amazon.FourSum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums,target,4, 0);
    }
    public List<List<Integer>> nSum(int[] nums, long target, int k, int start){
        List<List<Integer>> result = new ArrayList<>();
        if(k==2){
            int left = start;
            int right = nums.length-1;
            long sum = 0;
            while(left < right){
                sum = nums[left] + nums[right];
                int preLeft = left;
                int preRight = right;
                while(sum < target && left < right && nums[preLeft]==nums[left]){
                    left++;
                }
                while(sum > target && left < right && nums[preRight]==nums[right]){
                    right--;
                }
                if(sum==target){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    while(left < right && nums[preLeft]==nums[left]){
                        left++;
                    }
                    while(left < right && nums[preRight]==nums[right]){
                        right--;
                    }
                }
            }
        } else{
            for(int i = start;i<nums.length - k + 1;i++){
                List<List<Integer>> tmp = nSum(nums,target - nums[i],k-1,i+1);
                for(List<Integer> tmpItem:tmp){
                    ArrayList<Integer> tmpResult = new ArrayList<>(tmpItem);
                    tmpResult.add(0,nums[i]);
                    result.add(tmpResult);
                }
                while(i < nums.length-k && nums[i+1]==nums[i]){
                    i++;
                }
            }
        }
        return result;
    }
}
