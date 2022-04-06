package 图.RecorderRoutesToMakeAllPathsLeadToTheCityZero1466;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
public class Solution2 {
    public int minReorder(int n, int[][] connections) {
        // use DFS
        //adjacency list
        List<List<int[]>> graph = new ArrayList();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i < connections.length; i++){
            graph.get(connections[i][0]).add(new int[]{connections[i][1],1});
            graph.get(connections[i][1]).add(new int[]{connections[i][0],0});
        }

        boolean[] visited = new boolean[n];

        return dfs(graph,visited,0);
    }

    public int dfs(List<List<int[]>> graph, boolean[] visited, int current){
        int count = 0;
        visited[current] = true;

        for(int k = 0;k<graph.get(current).size();k++){
            int nextCurrent = graph.get(current).get(k)[0];
            if(visited[nextCurrent]==false){
                count += graph.get(current).get(k)[1];
                count += dfs(graph,visited,nextCurrent);
            }
        }
        return count;
    }
}
