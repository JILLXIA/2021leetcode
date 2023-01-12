package Top100Question.SquaresOfASortedArray977;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int current = nums.length - 1;
        while(left <= right){
            if(Math.abs(nums[left]) >= Math.abs(nums[right])){
                result[current] = nums[left] * nums[left];
                left++;
            } else {
                result[current] = nums[right] * nums[right];
                right--;
            }
            current--;
        }
        return result;
    }
}
