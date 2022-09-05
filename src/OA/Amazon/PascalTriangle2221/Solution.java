package OA.Amazon.PascalTriangle2221;

public class Solution {
    public int triangularSum(int[] nums) {
        return find(nums,nums.length);
    }

    public int find(int[] nums, int length){
        if(length==1){
            return nums[0];
        }
        for(int i = 0;i<length-1;i++){
            nums[i] = (nums[i] + nums[i+1])%10;
        }
        return find(nums,length-1);
    }
}
