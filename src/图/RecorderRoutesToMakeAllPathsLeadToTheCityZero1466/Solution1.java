package 图.RecorderRoutesToMakeAllPathsLeadToTheCityZero1466;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
public class Solution1 {
    public int minReorder(int n, int[][] connections) {
        //adjacency list
        List<List<int[]>> graph = new ArrayList();
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        // int[][] graph = new int[n][n];
        for(int i = 0;i < connections.length; i++){
            graph.get(connections[i][0]).add(new int[]{connections[i][1],1});
            graph.get(connections[i][1]).add(new int[]{connections[i][0],0});
            // graph[connections[i][0]][connections[i][1]] = 1;
            // graph[connections[i][1]][connections[i][0]] = -1;
        }

        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        set.add(0);

        while(!deque.isEmpty()){
            int tmp = deque.pollFirst();
            for(int k = 0;k < graph.get(tmp).size(); k++ ){
                if(!set.contains(graph.get(tmp).get(k)[0])){
                    deque.offerLast(graph.get(tmp).get(k)[0]);
                    set.add(graph.get(tmp).get(k)[0]);
                    count += graph.get(tmp).get(k)[1];
                }
            }
        }
        return count;
    }
}
