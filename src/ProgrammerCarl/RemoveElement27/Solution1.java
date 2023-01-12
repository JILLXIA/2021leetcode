package ProgrammerCarl.RemoveElement27;

public class Solution1 {
    public int removeElement(int[] nums, int val) {
        // slow fast pointer
        int slow = 0;
        int fast = 0;
        for(fast = 0;fast < nums.length;fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
