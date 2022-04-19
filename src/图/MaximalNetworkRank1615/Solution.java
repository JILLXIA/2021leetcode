package 图.MaximalNetworkRank1615;

/**
 * There is an infrastructure of n cities with some number of roads
 * connecting these cities. Each roads[i] = [ai, bi] indicates
 * that there is a bidirectional road between cities ai and bi.
 *
 * The network rank of two different cities is defined as the
 * total number of directly connected roads to either city.
 * If a road is directly connected to both cities, it is only counted once.
 *
 * The maximal network rank of the infrastructure is the maximum network
 * rank of all pairs of different cities.
 *
 * Given the integer n and the array roads, return the maximal network
 * rank of the entire infrastructure.
 */
public class Solution {
	public int maximalNetworkRank(int n, int[][] roads) {
		int[] degree = new int[n];
		boolean[][] connected = new boolean[n][n];
		for(int i = 0;i< roads.length;i++){
			degree[roads[i][0]]++;
			degree[roads[i][1]]++;
			connected[roads[i][0]][roads[i][1]] = true;
			connected[roads[i][1]][roads[i][0]] = true;
		}
		// brutal force
		// cannot use 2 point to notify the max number and second max number.
		// maybe all the node have the same degree
		int result = 0;
		for(int i = 0;i< degree.length;i++){
			for(int j = i+1;j<degree.length;j++){
				result = Math.max(result,connected[i][j]? degree[i]+degree[j]-1 :degree[i]+degree[j]);
			}
		}
		return result;
	}
}
