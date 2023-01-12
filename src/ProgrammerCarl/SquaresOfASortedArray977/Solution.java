package ProgrammerCarl.SquaresOfASortedArray977;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted
 * in non-decreasing order.
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        // extra space
        // three pointer
        int left = 0;
        int right = nums.length - 1;
        int curr = nums.length - 1;
        int[] answer = new int[nums.length];

        while(left <= right){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                answer[curr] = nums[right] * nums[right];
                right--;
            } else {
                answer[curr] = nums[left] * nums[left];
                left++;
            }
            curr--;
        }
        return answer;
    }
}
