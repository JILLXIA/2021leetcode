package labuladong.Subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Solution {
	List<Integer> path = new ArrayList<>();
	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		backTrace(nums,0);
		return result;
	}

	public void backTrace(int[] nums, int start){
		result.add(new ArrayList<>(path));
		if(start==nums.length){
			return;
		}
		for(int i = start;i<nums.length;i++){
			path.add(nums[i]);
			backTrace(nums,i+1);
			path.remove(path.size()-1);
		}
	}
}
