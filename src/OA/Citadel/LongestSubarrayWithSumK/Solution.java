package OA.Citadel.LongestSubarrayWithSumK;

public class Solution {
    public int atMostSum(int[] nums, int k){
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(sum + nums[i] <= k){
                sum += nums[i];
                count++;
            }else if(sum != 0){
                sum = sum -nums[i-count] + nums[count];
            }
            result = Math.max(result,count);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.atMostSum(new int[]{1,2,1,0,1,1,0},4));
    }
}
