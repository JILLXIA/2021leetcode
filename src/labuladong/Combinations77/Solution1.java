package labuladong.Combinations77;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return result;
    }

    public void dfs(int start, int n, int k) {
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(start > n) {
            return;
        }
        for(int i = start; i <= n; i++) {
            path.add(i);
            dfs(i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
