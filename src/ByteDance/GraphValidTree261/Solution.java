package ByteDance.GraphValidTree261;

/**
 * You have a graph of n nodes labeled from 0 to n - 1.
 * You are given an integer n and a list of edges where edges[i] = [ai, bi]
 * indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree,
 * and false otherwise.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // multiple root
        // circle
        //
        UF uf = new UF(n);
        for(int[] edge: edges){
            if(uf.isConnected(edge[0],edge[1])){
                return false;
            }
            uf.union(edge[0],edge[1]);
        }

        if(uf.getCount()!=1){
            return false;
        }
        return true;
    }
}

class UF{
    int[] parents;
    int count;

    public UF(int size){
        this.count = size;
        parents = new int[size];
        for(int i = 0;i<parents.length;i++){
            parents[i] = i;
        }
    }

    public int getCount(){
        return count;
    }


    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }
        count--;
        parents[pRoot] = qRoot;
    }

    public boolean isConnected(int p, int q){
        return find(p)==find(q);
    }

    public int find(int p){
        if(parents[p]!=p){
            parents[p] = find(parents[p]);
        }
        return parents[p];
    }
}