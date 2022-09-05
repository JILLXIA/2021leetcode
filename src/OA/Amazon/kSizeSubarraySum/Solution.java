package OA.Amazon.kSizeSubarraySum;

import java.util.HashSet;

public class Solution {
    public int kSizeSubarraySum(int[] nums, int k){
        if(k < nums.length){
            return -1;
        }
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<k;i++){
            sum += nums[i];
            set.add(nums[i]);
        }
        int result = sum;
        for(int i = k;i<nums.length;i++){
            sum += nums[i];
            sum -= nums[i-k];
            set.add(nums[i]);
            set.remove(nums[i-k]);
            if(set.size()==k){
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}
