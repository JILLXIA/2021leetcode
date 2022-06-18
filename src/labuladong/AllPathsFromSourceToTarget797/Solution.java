package labuladong.AllPathsFromSourceToTarget797;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class Solution {
	List<Integer> tmp = new ArrayList<>();
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		boolean[] isVisited = new boolean[graph.length];
		dfs(graph, isVisited,0);
		return result;
	}

	public void dfs(int[][] graph, boolean[] isVisited, int index){
		tmp.add(index);
		isVisited[index] = true;
		if(index== graph.length-1){
			// 遍历到n-1
			result.add(new ArrayList<>(tmp));
			tmp.remove(tmp.size()-1);
			return;
		}

		for(int i: graph[index]){
			dfs(graph, isVisited,i);
		}
		tmp.remove(tmp.size()-1);
	}
}
