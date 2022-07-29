package labuladong.CombinationSum39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates
 * where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers
 * is different.
 *
 * It is guaranteed that the number of unique combinations
 * that sum up to target is less than 150 combinations for the given input.
 */
public class Solution {
	List<Integer> path = new ArrayList<>();
	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		backTrace(candidates, target, 0,0);
		return result;
	}

	public void backTrace(int[] candidates, int target, int index, int sum){
		if(sum==target){
			result.add(new ArrayList<>(path));
			return;
		}

		for(int i = index;i<candidates.length;i++){
			if(sum + candidates[i] > target){
				break;
			}
			path.add(candidates[i]);
			backTrace(candidates, target,i,sum + candidates[i]);
			path.remove(path.size()-1);
		}
	}
}
