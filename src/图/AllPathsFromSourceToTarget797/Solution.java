package 图.AllPathsFromSourceToTarget797;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all
 * nodes you can visit from node i (i.e., there is a directed
 * edge from node i to node graph[i][j]).
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // transfrom graph to a 2-dimension array with 0 & 1
        int[][] arr = new int[graph.length][graph.length];
        int n = graph.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<graph[i].length;j++){
                arr[i][graph[i][j]] = 1;
            }
        }
        tmp.add(0); // add the first node
        for(int i = 0;i<n;i++){
            if(arr[0][i]==1){
                dfs(arr,i);
            }
        }
        return result;
    }

    public void dfs(int[][] arr, int curr){
        tmp.add(curr);
        if(curr == arr.length-1){
            // move to the n-1 node
            result.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);
            return ;
        }

        for(int i = 0;i<arr.length;i++){
            if(arr[curr][i] == 1){
                dfs(arr,i);
            }
            if(i == arr.length - 1){
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
