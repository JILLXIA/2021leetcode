package 图.RecorderRoutesToMakeAllPathsLeadToTheCityZero1466;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.


 */
// Memory Limit Exceeded
public class Solution {
    public int minReorder(int n, int[][] connections) {
        int[][] graph = new int[n][n];
        for(int i = 0;i < connections.length; i++){
            graph[connections[i][0]][connections[i][1]] = 1;
            graph[connections[i][1]][connections[i][0]] = -1;
        }

        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(0);
        set.add(0);

        while(!deque.isEmpty()){
            int tmp = deque.pollFirst();
            for(int k = 0;k < graph[tmp].length; k++ ){
                if(!set.contains(k)){
                    if(graph[tmp][k]==1){
                        deque.offerLast(k);
                        set.add(k);
                    } else if(graph[tmp][k]==-1){
                        deque.offerLast(k);
                        set.add(k);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
