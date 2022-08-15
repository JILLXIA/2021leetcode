package contest.Weekly305.NumberOfArithmeticTriplets;

public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] arr = new boolean[201];
        for(int num:nums){
            arr[num] = true;
        }
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] + diff + diff > 200){
                continue;
            }
            if(arr[nums[i]+diff] && arr[nums[i]+diff*2]){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.arithmeticTriplets(new int[]{4,5,6,7,8,9},2));
    }
}
