package 图.ShortestPathVisitingAllNodes847;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * You have an undirected, connected graph of n nodes labeled from 0 to n - 1. 
 * You are given an array graph where graph[i] is a list of all the nodes connected with 
 * node i by an edge.

Return the length of the shortest path that visits every node. 
You may start and stop at any node, you may revisit nodes multiple times, 
and you may reuse edges.
 */
public class Solution {
    // step1: find a way to illustrate the edge and node, we use three Integers. 
    // bitmask: whether the node is visited; n <=12 it is enough to use a Integer.
    // curr: current node we visit
    // cost: the number of path we cost
    public int shortestPathLength(int[][] graph) {
        // initial a queue and set to prepare for BFS
        Deque<Truple> deque = new LinkedList<>();
        Set<Truple> set = new HashSet<>();

        int N = graph.length;

        // initial the queue, all the n node can be the first
        for(int i = 0;i < N; i++){
            int tmp = 1<<i;
            deque.offerLast(new Truple(tmp, i, 0));
            set.add(new Truple(tmp, i, 0));
        }

        while(!deque.isEmpty()){
            Truple tmpTruple = deque.pollFirst();
            if(tmpTruple.bitmask == (1<<N)-1){
                return tmpTruple.cost;
            }
            for(int i : graph[tmpTruple.curr]){
                Truple trupleNext = new Truple(tmpTruple.bitmask | (1<<i), i, tmpTruple.cost+1);
                if(!set.contains(trupleNext)){
                    set.add(trupleNext);
                    deque.offerLast(trupleNext);
                }
            }
        }
        return -1;
    }

//    public static void main(String[] args){
//        Solution s = new Solution();
//        s.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}});
//    }
    
}

class Truple {
    // all the classes extends from Object
    int bitmask;
    int curr;
    int cost;
    
    public Truple(int bitmask, int curr, int cost){
        this.bitmask = bitmask;
        this.curr  = curr;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o){
        // parameter must be the same
        Truple p = (Truple) o;
        return this.bitmask==p.bitmask && this.curr==p.curr;
    }

    @Override
    public int hashCode() {
        return 1331 * bitmask + 7193 * curr;
    }
}