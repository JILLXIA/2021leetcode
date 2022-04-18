package 图.MinimumNumberOfVerticesToReachAllNodes1557;

import java.util.ArrayList;
import java.util.List;

// Union find
public class Solution1 {
	public int findParent(int[] parents, int n){
		// find the ancestor of each node
		if(parents[n]==n){
			return n;
		}
		return parents[n] = findParent(parents,parents[n]);
	}
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		int[] parents = new int[n];
		for(int i = 0;i < n;i++){
			parents[i] = i;
		}

		for(List<Integer> tmp : edges){
			int startNode = tmp.get(0);
			int endNode = tmp.get(1);
			int startParent = findParent(parents,startNode);
			parents[endNode] = startParent;
		}

		List<Integer> result = new ArrayList<>();
		for(int i = 0;i< n;i++){
			if(parents[i]==i){
				result.add(i);
			}
		}
		return result;
	}
}
