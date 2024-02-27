package labuladong.AllPathsFromSourceToTarget797;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> path = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // need to know where the loop end
        // end condition, find the index = n-1
        // int n = graph.length;
        dfs(graph, 0);
        return path;

    }

    public void dfs(int[][] graph, int index) {
        tmp.add(index);

        if(index == graph.length - 1) {
            path.add(new ArrayList<>(tmp)); // important
            tmp.remove(tmp.size() - 1);
            return;
        }

        for(int i = 0; i < graph[index].length; i++) {
            dfs(graph, graph[index][i]);
        }
        tmp.remove(tmp.size() - 1);
    }
}
