package OA.TikTok.IsThisATree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
}
class Node{
    String val;
    List<Node> next;
    Node parent;
    public Node(String val){
        this.val = val;
        next = new ArrayList<>();
        parent = null;
    }
}
class UF{
    int count;
    int[] parents;
    public UF(int size){
        this.count = size;
        parents = new int[26];
        for(int i = 0;i<parents.length;i++){
            parents[i] = i;
        }
    }

    public int find(int root){
        if(root!=parents[root]){
            parents[root] = find(parents[root]);
        }
        return parents[root];
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot){
            return;
        }
        parents[pRoot] = qRoot;
        count--;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public int getCount(){
        return count;
    }
}