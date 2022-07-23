package labuladong.CombinationSumII40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 */
public class Solution {
	List<Integer> path = new ArrayList<>();
	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		// not contain duplicate combination -> visited数组 / 位运算 / 排序 arr[i]!=arr[i-1]
		Arrays.sort(candidates);
		backTrace(candidates,target, 0,0);
		return result;
	}

	public void backTrace(int[] candidates, int target, int sum, int start){
		if(sum==target){
			result.add(new ArrayList<>(path));
			return;
		}

		for(int i = start;i<candidates.length;i++){
			if(sum + candidates[i] > target){
				continue;
			}

			if(i!=start && candidates[i]==candidates[i-1]){
				continue;
			}

			path.add(candidates[i]);
			backTrace(candidates,target,sum+candidates[i],i+1);
			path.remove(path.size()-1);
		}
	}
}
