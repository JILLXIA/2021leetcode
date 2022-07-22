package labuladong.SubsetsII90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Solution {
	List<Integer> path = new ArrayList<>();
	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		backTrace(nums,0,0);
		return result;
	}

	public void backTrace(int[] nums, int start,int used){
		result.add(new ArrayList<>(path));

		if(start==nums.length){
			return;
		}
		int usedLine = 0;
		for(int i = start;i<nums.length;i++){
			if((usedLine >> (nums[i]+10) & 1 )==1){
				continue;
			}
			path.add(nums[i]);
			usedLine |= 1<<(nums[i]+10);
			backTrace(nums,i+1,used);
			path.remove(path.size()-1);
		}
	}
}
