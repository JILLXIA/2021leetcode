package contest.Weekly305.CheckIfThereIsAValidPartitionFoeTheAray;

import java.util.HashMap;

public class Solution {
    HashMap<Integer, Boolean> memo = new HashMap<>();

//    public static void main(String[] args) {
//        Solution s = new Solution();
//
//        System.out.println(s.validPartition(new int[]{1,1,1,2}));
//    }
    public boolean validPartition(int[] nums) {
        return dfs(nums,0);
    }

    public boolean dfs(int[] nums, int start){
        if(start >= nums.length){
            return true;
        }

        if(start==nums.length-1){
            return false;
        }

        if(memo.containsKey(start)){
            return memo.get(start);
        }

        boolean result1 = false;
        if(start+1<nums.length && nums[start]==nums[start+1]){
            result1 = dfs(nums,start+2);
        }

        boolean result2 = false;
        if(start+2<nums.length && nums[start]==nums[start+1] && nums[start+1]==nums[start+2]){
            result2 = dfs(nums,start+3);
        }

        boolean result3 = false;
        if(start+2<nums.length && nums[start]-nums[start+1]==-1
                && nums[start+1]-nums[start+2]==-1){
            result3 = dfs(nums,start+3);
        }

        boolean result = result1 || result2 || result3;
        memo.put(start,result);
        return result;
    }
}
