package labuladong.SortAnArray912;

/**
 * Given an array of integers nums, sort the array in ascending order.
 */
// merge-sort
// postOrder binary tree
public class Solution {
    int[] tmp;
    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        return sort(nums,0, nums.length-1);
    }
    public int[] sort(int[] nums, int low, int high){
        if(low>=high){
            return nums;
        }

        int mid = low + (high - low)/2;
        sort(nums,low,mid);
        sort(nums,mid+1,high);
        return merge(nums,low,mid,high);
    }
    public int[] merge(int[] nums, int low, int mid, int high){
        // sort the two array
        for(int i = low;i<=high;i++){
            tmp[i] = nums[i];
        }
        int lowIndex = low;
        int highIndex = mid+1;
        int currIndex = low;
        while(lowIndex<=mid || highIndex<=high){
            if(lowIndex>mid){
                nums[currIndex] = tmp[highIndex];
                highIndex++;
            } else if(highIndex>high){
                nums[currIndex] = tmp[lowIndex];
                lowIndex++;
            }else{
                if(tmp[lowIndex]<=tmp[highIndex]){
                    nums[currIndex] = tmp[lowIndex];
                    lowIndex++;
                }else{
                    nums[currIndex] = tmp[highIndex];
                    highIndex++;
                }
            }
            currIndex++;
        }
        return nums;
    }
}
