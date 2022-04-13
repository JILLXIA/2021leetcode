package 图.MinimumNumberOfVerticesToReachAllNodes1557;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
 *
 * Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
 *
 * Notice that you can return the vertices in any order.
 */
public class Solution {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		// record the in-degrees of every node
		int[] inDegree = new int[n];
		for(int i = 0;i < edges.size();i++){
			inDegree[edges.get(i).get(1)]++;
		}
		List<Integer> res = new ArrayList<>();
		for(int i = 0;i < n;i++){
			if(inDegree[i]==0){
				res.add(i);
			}
		}
		return res;
	}
}
