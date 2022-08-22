package labuladong.Combinations77;


import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 */
public class Solution {
	List<Integer> path = new ArrayList<>();
	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> combine(int n, int k) {
		backTrace(n,k,1);
		return result;
	}

	public void backTrace(int n, int k, int start){
		if(path.size()==k){
			result.add(new ArrayList<>(path));
			return;
		}

		for(int i = start;i<=n;i++){
			path.add(i);
			backTrace(n,k,i+1);
			path.remove(path.size()-1);
		}
	}
}
