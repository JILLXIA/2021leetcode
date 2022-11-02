package Top100Question.ProductOfArrayExceptSelf238;

import java.util.Arrays;

/**
 * Given an integer array nums,
 * return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed
 * to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time
 * and without using the division operation.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        Arrays.fill(leftProduct,1);
        Arrays.fill(rightProduct,1);

        for(int i = 1;i<nums.length;i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        for(int i = nums.length-2;i>=0;i--){
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}
