package contest.Weekly308.LongestSubsequenceWithLimitedSum;

import java.util.Arrays;

public class Solution {
	public int[] answerQueries(int[] nums, int[] queries) {
		Arrays.sort(nums);
		int[] answer = new int[queries.length];
		int[] preSum = new int[nums.length];
		preSum[0] = nums[0];
		for(int i = 1;i< nums.length;i++){
			preSum[i] = preSum[i-1] + nums[i];
		}

		for(int i = 0;i< queries.length;i++){
			int tmp = queries[i];
			int left = 0;
			int right = nums.length;
			while(left < right){
				int mid = left + (right - left)/2;
				if(preSum[mid] > tmp){
					right = mid;
				} else if(preSum[mid] < tmp){
					left = mid + 1;
				} else {
					left = mid + 1;
				}
			}
			answer[i] = left;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] result = s.answerQueries(new int[]{4,5,2,1},new int[]{3,10,21});
		for(int i:result){
			System.out.println(i);
		}
	}
}
