package labuladong.PermutationsII47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 */
public class Solution {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	boolean[] isVisited;
	public List<List<Integer>> permuteUnique(int[] nums) {
		isVisited = new boolean[nums.length];
		// put elemtents of the same value next to each other
		Arrays.sort(nums);
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
			if(i > 0 && nums[i] == nums[i-1] && !isVisited[i-1]){
				// in the element share the same value, we should maintain the order of these element.
				// only when the first element be used, the next can be used
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
