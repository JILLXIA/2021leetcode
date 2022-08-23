package contest.WeeklyContest307.FindTheKSumOfAnArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	PriorityQueue<Long> pq = new PriorityQueue<>();
	long sum = 0;
	public long kSum(int[] nums, int k) {
		boolean[] isVisited = new boolean[nums.length];
		backTrace(nums,isVisited,0,k);
		pq.peek();
		return pq.peek();
	}

//	public static void main(String[] args) {
//		Solution s = new Solution();
//		System.out.println(s.kSum(new int[]{2,4,-2},5));
//	}

	public void backTrace(int[] nums, boolean[] isVisited, int start,int k){
		// TODO
		if(pq.size() <k ){
			pq.add(sum);
		} else{
			if(sum > pq.peek()) {
				pq.poll();
				pq.add(sum);
			}
		}

		if(start >= nums.length || isVisited[start]){
			return;
		}

		for(int i = start;i<nums.length;i++){
			isVisited[i] = true;
			sum += (long)nums[i];
			backTrace(nums,isVisited,i+1,k);
			sum -= (long)nums[i];
			isVisited[i] = false;
		}
	}
}
