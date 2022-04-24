package 图.IsGraphBipartite785;

import javafx.scene.control.Pagination;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

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
	public boolean isBipartite(int[][] graph) {
		int[] arr = new int[graph.length];
		for(int i = 0;i<arr.length;i++) {
			if(arr[i] == 0 && !dfs(graph,arr,1,i)){ // 可以遍历完所有连通图
				return false;
			}
		}
		return true;
	}

	public boolean dfs(int[][] graph,int[] arr, int color, int index){
		if(arr[index]!=0){
			return arr[index]==color;
		}

		arr[index] = color;
		for(int next : graph[index]){
			if(!dfs(graph,arr,-color,next)){
				return false;
			}
		}
		return true;
	}
}
