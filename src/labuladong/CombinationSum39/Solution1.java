package labuladong.CombinationSum39;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

        for(int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i],i);
            path.remove(path.size() - 1);
        }
    }
}
