package labuladong.GraphValidTree261;

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
		UF uf = new UF(n);
		for(int i = 0;i< edges.length;i++){
			if(uf.isConnected(edges[i][0],edges[i][1])){
				return false;
			}
			uf.union(edges[i][0],edges[i][1]);
		}
		// all the node share the same root
		return uf.getCount()==1;
	}
}

class UF{
	int[] parents;
	int size;
	int count;

	public UF(int size){
		this.size = size;
		parents = new int[size];
		for(int i = 0;i<size;i++){
			parents[i] = i;
		}
		count = size;
	}

	public int find(int p){
		if(parents[p]!=p){
			parents[p] = find(parents[p]);
		}
		return parents[p];
	}

	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot==qRoot){
			return ;
		}
		parents[qRoot] = pRoot;
		count--;
	}

	public boolean isConnected(int p, int q){
		return find(p)==find(q);
	}

	public boolean shareSameRoot(){
		for(int i = 0;i<parents.length-1;i++){
			if(find(parents[i])!=find(parents[i+1])){
				return false;
			}
		}
		return true;
	}

	public int getCount(){
		return count;
	}
}