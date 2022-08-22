package labuladong.MinCostToConnectAllPoints1584;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 */
public class Solution {
	public int minCostConnectPoints(int[][] points) {
		List<int[]> list = new ArrayList<>();
		for(int i = 0;i<points.length-1;i++){
			for(int j = i+1;j<points.length;j++){
				list.add(new int[]{i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])});
			}
		}

		Collections.sort(list,(a,b) -> a[2]-b[2]);
		UF uf = new UF(points.length);
		int weight = 0;
		for(int[] arr:list){
			if(uf.isConnected(arr[0],arr[1])){
				continue;
			}
			weight += arr[2];
			uf.union(arr[0],arr[1]);
		}
		return weight;
	}
}

class UF{
	int[] parents;
	int count;

	public UF(int size){
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
			return;
		}
		parents[qRoot] = pRoot;
		count--;
	}

	public boolean isConnected(int p, int q){
		return find(p)==find(q);
	}

	public int getCount(){
		return count;
	}
}