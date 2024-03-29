package codeSignal.RearrangeOrderArray;

/**
 * You are given an array of integers a. A new array b is generated by rearranging the elements of a in the following way:
 *
 * b[0] is equal to a[0];
 * b[1] is equal to the last element of a;
 * b[2] is equal to a[1];
 * b[3] is equal to the second-last element of a;
 * b[4] is equal to a[2];
 * b[5] is equal to the third-last element of a;
 * and so on.
 * Your task is to determine whether the new array b is sorted in strictly ascending order or not.
 */
public class Solution {
    public boolean rearrangeOrderList(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int last = Integer.MIN_VALUE;
        boolean flag = true;
        while(left <= right){
            if(flag){
                if(nums[left] < last){
                    return false;
                }
                last = nums[left];
                left++;
            } else {
                if(nums[right] < last){
                    return false;
                }
                last = nums[right];
                right--;
            }
            flag = !flag;
        }
        return true;
    }
}
