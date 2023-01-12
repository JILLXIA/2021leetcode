package Top100Question.RotateArray189;

/**
 * Given an array,
 * rotate the array to the right by k steps, where k is non-negative.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int rotate = k % nums.length;
        for(int i = 0;i<rotate;i++){
            result[i] = nums[nums.length  - rotate + i];
        }

        for(int i = 0;i<nums.length - rotate;i++){
            result[rotate + i] = nums[i];
        }

        for(int i = 0;i<nums.length;i++){
            nums[i] = result[i];
        }
        return;
    }
}
