package labuladong.ConnectingCitiesWithMinimumCost1135;

import java.util.Arrays;

/**
 * There are n cities labeled from 1 to n.
 * You are given the integer n and an array connections where
 * connections[i] = [xi, yi, costi] indicates that the cost of connecting city
 * xi and city yi (bidirectional connection) is costi.
 *
 * Return the minimum cost to connect all the n cities
 * such that there is at least one path between each pair of cities.
 * If it is impossible to connect all the n cities, return -1,
 *
 * The cost is the sum of the connections' costs used.
 */
public class Solution {
	public int minimumCost(int n, int[][] connections) {
		// sort the connections by cost
		Arrays.sort(connections, (a,b) -> a[2]-b[2]);
		UF uf = new UF(n);
		int weight = 0;
		for(int i = 0;i < connections.length;i++){
			if(uf.isConnected(connections[i][0]-1,connections[i][1]-1)){
				continue;
			}
			weight += connections[i][2];
			uf.union(connections[i][0]-1,connections[i][1]-1);
		}
		if(uf.getCount()!=1){
			return -1;
		}
		return weight;
	}
}

class UF{
	int[] parents;
	int count;

	public UF(int size){
		parents = new int[size];
		count = size;
		for(int i = 0;i < size;i++){
			parents[i] = i;
		}
	}

	public int find(int p){
		if(parents[p] != p){
			parents[p] = find(parents[p]);
		}
		return parents[p];
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
		return find(p) == find(q);
	}

	public int getCount(){
		return count;
	}
}