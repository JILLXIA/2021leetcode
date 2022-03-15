package 图.AllPathsFromSourceToTarget797;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // there is need to change the graph into array with 0 & 1
        tmp.add(0);
        dfs(graph,0);
        return result;
    }

    public void dfs(int[][] graph, int curr){
        if(curr == graph.length-1){
            result.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i : graph[curr]){
            tmp.add(i);
            dfs(graph,i);
            tmp.remove(tmp.size()-1);
        }
    }
}
