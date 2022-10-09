package ByteDance.NetworkDelayTime743;

import java.util.*;

/**
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges
 * times[i] = (ui, vi, wi), where ui is the source node, vi is the target node,
 * and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k.
 * Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 */
public class Solution {
    class DestNode {
        int dest;
        int weight;

        public DestNode(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<DestNode>[] graph = new List[n+1];

        for(int i = 0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] time:times){
            graph[time[0]].add(new DestNode(time[1],time[2]));
        }

        PriorityQueue<DestNode> pq = new PriorityQueue<>(new Comparator<DestNode>(){
            @Override
            public int compare(DestNode d1, DestNode d2){
                return d1.weight - d2.weight;
            }
        });
        int[] distTo = new int[n+1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        pq.add(new DestNode(k,0));
        distTo[k] = 0;
        while(!pq.isEmpty()){
            DestNode tmp = pq.poll();
            for(DestNode next: graph[tmp.dest]){
                if(next.weight + tmp.weight < distTo[next.dest]){
                    distTo[next.dest] = next.weight + tmp.weight;
                    pq.add(new DestNode(next.dest,next.weight + tmp.weight));
                }
            }
        }

        int result = 0;
        for(int i = 1;i<distTo.length;i++){
            result = Math.max(result,distTo[i]);
        }
        return result==Integer.MAX_VALUE ? -1: result;

    }
}
