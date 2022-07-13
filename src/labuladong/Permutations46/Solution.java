package labuladong.Permutations46;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers,
 * return all the possible permutations. You can return the answer in any order.
 */
public class Solution {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	boolean[] isVisited;
	public List<List<Integer>> permute(int[] nums) {
		isVisited = new boolean[nums.length];
		backTrace(nums);
		return result;
	}

	public void backTrace(int[] nums){
		if(path.size()== nums.length){
			result.add(new ArrayList<>(path));
			return;
		}

		for(int i = 0;i<nums.length;i++){
			if(isVisited[i]){
				continue;
			}
			path.add(nums[i]);
			isVisited[i] = true;
			backTrace(nums);
			path.remove(path.size()-1);
			isVisited[i] = false;
		}
	}
}
