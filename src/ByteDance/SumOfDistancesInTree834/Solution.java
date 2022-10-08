package ByteDance.SumOfDistancesInTree834;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
 *
 * You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 *
 * Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
 */
public class Solution {
    int[] size;
    int f0 = 0;
    // 不一定0总是根节点
    int[] isVisited;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // f(child) = f(parent) + a - b;
        // b = size(child)
        // a = n - b
        // f(child) = f(parent) + n - 2 * size(child)

        // get size of each child
        // get f(0)
        size = new int[30000];
        isVisited = new int[30000];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i< edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0,graph);
        Arrays.fill(isVisited,0);
        dfs2(0,graph,0);
        Arrays.fill(isVisited,0);
        int[] result = new int[n];
        result[0] = f0;
        dfs3(result,0,graph);
        return result;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(Arrays.toString(s.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
//    }
    public void dfs3(int[] result, int root, List<List<Integer>> graph){
        for(int nextRoot: graph.get(root)) {
            if(result[nextRoot]==0) {
                result[nextRoot] = result[root] + result.length - 2 * size[nextRoot];
                dfs3(result, nextRoot, graph);
            }
        }
    }

    public void dfs2(int root, List<List<Integer>> graph, int height){
        if(isVisited[root]==1){
            return;
        }
        isVisited[root] = 1;
        f0 += height;
        for(int nextRoot: graph.get(root)){
            dfs2(nextRoot,graph,height + 1);
        }
    }
    public int dfs(int root, List<List<Integer>> graph){
        if(isVisited[root]==1){
            return 0;
        }
        isVisited[root] = 1;
        if(graph.get(root).size()==0){
            size[root] = 1;
            return 1;
        }

        int result = 0;
        for(int nextRoot: graph.get(root)){
            result += dfs(nextRoot,graph);
        }
        result++;
        size[root] = result;
        return result;
    }
}
