package OA.Citadel.SubarraySumsDivisibleByK974;

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 */
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        HashMap<Integer, Integer> divisionToNumber = new HashMap<>();
        divisionToNumber.put(0,1);
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            while(sum < 0){
                sum += k;
            }
            if(divisionToNumber.containsKey(sum%k)){
                result += divisionToNumber.get(sum%k);
            }
            divisionToNumber.put(sum % k,divisionToNumber.getOrDefault(sum % k,0)+1);
        }
        return result;
    }
// 4 9 9
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }
}
