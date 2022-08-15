package contest.Weekly305.ReachableNodesWithRestrictions;

import java.util.*;

public class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graph = new List[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int result = 0;
        Deque<Integer> pq = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i:restricted){
            set.add(i);
        }
        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;

        pq.offerLast(0);
        while(!pq.isEmpty()){
            int tmp = pq.pollFirst();
            result++;
            for(int node:graph[tmp]){
                if(set.contains(node) || isVisited[node]){
                    continue;
                }
                pq.offerLast(node);
                isVisited[node] = true;
            }
        }
        return result;
    }
}
