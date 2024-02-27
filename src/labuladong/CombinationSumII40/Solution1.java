package labuladong.CombinationSumII40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort
        Arrays.sort(candidates);
        dfs(candidates, target, 0,0);
        return result;
    }
    public void dfs(int[] candidates, int target, int sum, int start) {
        if(sum > target) {
            return;
        }

        if(sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(start >= candidates.length) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if(i!=start && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i],i + 1);
            path.remove(path.size() - 1);
        }
    }
}
