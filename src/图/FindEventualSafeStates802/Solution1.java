package 图.FindEventualSafeStates802;

import java.util.ArrayList;
import java.util.List;
// if have cycle; use white-grey-black
public class Solution1 {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		// DFS white-grey-black
		List<Integer> result = new ArrayList<>();
		int[] color = new int[graph.length];
		// white: havn't visited the node
		// grey: transversaling the node, or the node in cycle
		// black: safe node
		for(int i = 0;i< graph.length;i++){
			if(dfs(graph,color,i)){
				result.add(i);
			}
		}
		return result;
	}

	public boolean dfs(int[][] graph,int[] color, int index){
		if(color[index]!=0){
			return color[index] == 2;
		}

		color[index] = 1;
		for(int i = 0;i<graph[index].length;i++){
			if(!dfs(graph,color,graph[index][i])){
				return false;
			}
		}
		color[index] = 2;
		return true;
	}
}
