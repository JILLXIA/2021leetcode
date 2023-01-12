package Top100Question.RotateArray189;

public class Solution1 {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0,k % nums.length - 1);
        reverse(nums, k % nums.length, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
