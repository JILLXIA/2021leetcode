package labuladong.IsGraphBipartite785;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 *
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 */
public class Solution {
	boolean result = true;
	public boolean isBipartite(int[][] graph) {
		int[] isVisited = new int[graph.length];
		for(int i = 0;i< graph.length;i++){
			if(isVisited[i]==0){
				dfs(graph, isVisited,1,i);
			}
		}
		return result;
	}
	public void dfs(int[][] graph, int[] isVisited, int flag, int index){
		if(isVisited[index]==-flag){
			// 已经被赋值过，但是不是当前的flag
			result = false;
			return;
		}

		if(!result || isVisited[index]==flag){
			return;
		}

		isVisited[index] = flag;
		for(int i:graph[index]){
			dfs(graph, isVisited, -flag, i);
		}
	}
	public static void main(String[] args){
		Solution s = new Solution();
		s.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}});
	}
}
