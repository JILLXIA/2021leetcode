package 图.NumberOfOperationsToMakeNetworkConnected1319;

import java.util.Arrays;

/**
 * There are n computers numbered from 0 to n - 1 connected
 * by ethernet cables connections forming a network where
 * connections[i] = [ai, bi] represents a connection between
 * computers ai and bi. Any computer can reach any other computer
 * directly or indirectly through the network.
 *
 * You are given an initial computer network connections.
 * You can extract certain cables between two directly connected
 * computers, and place them between any pair of disconnected
 * computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order
 * to make all the computers connected. If it is not possible,
 * return -1.
 */
public class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n){
            return -1;
        }
        // count the extra cable
        // union?
        UnionFind uf = new UnionFind(n);
        for(int i = 0;i<connections.length;i++){
            uf.union(connections[i][0],connections[i][1]);
        }
        return uf.getCount()-1;
    }
}

class UnionFind{
    private int count; // number of the connected group
    public int getCount(){
        return count;
    }

    int[] size; // size of every node
    int[] parent; // father node

    public UnionFind(int n){
        this.count = n;
        this.size = new int[n];
        Arrays.fill(this.size,1);
        this.parent = new int[n];
        for(int i = 0;i<n;i++){
            this.parent[i] = i;
        }
    }

    public int find(int x){
        // find the root node
        while(parent[x]!=x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p,int q){
        int rootp = find(p);
        int rootq = find(q);
        if(rootp == rootq){
            return ; // p,q in the same connected group
        }
        if(size[rootp]>size[rootq]){
            parent[rootq] = rootp;
            size[rootp] += size[rootq];
        }else{
            parent[rootp] = rootq;
            size[rootq] += size[rootp];
        }
        count--;
    }
}