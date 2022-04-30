package labuladong.SubarraySumEqualsK560;

import java.util.HashMap;

public class Solution1 {
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer,Integer> preSum = new HashMap<>();
		preSum.put(0,1);
		int pre = 0;
		// 直接根据遍历顺序 确认index大小
		int result = 0;
		for(int i = 0;i< nums.length;i++){
			int currSum = pre + nums[i];
			pre = currSum;
			if(preSum.containsKey(currSum-k)){
				result += preSum.get(currSum-k);
			}
			preSum.put(currSum,preSum.getOrDefault(currSum,0)+1);
		}
		return result;
	}
}
