package 图.PossibleBipartition886;

import java.util.ArrayList;
import java.util.List;

/**
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 */
public class Solution {
	public boolean possibleBipartition(int n, int[][] dislikes) {
		ArrayList<Integer>[] graphArrayList = new ArrayList[n+1];

		for(int i = 0;i<=n;i++){
			graphArrayList[i] = new ArrayList<>();
		}
		for(int i = 0;i< dislikes.length;i++){
			graphArrayList[dislikes[i][0]].add(dislikes[i][1]);
			graphArrayList[dislikes[i][1]].add(dislikes[i][0]);
		}

		int[] visited = new int[n+1];

		for(int i = 1;i<n;i++){
			if(visited[i]==0 && !dfs(graphArrayList,visited,i,1)){
				return false;
			}
		}
		return true;
	}

	public boolean dfs(ArrayList<Integer>[] graphArrayList, int[] visited, int index, int color){
		if(visited[index]!=0){
			return visited[index]==color;
		}
		visited[index] = color;
		for(int next: graphArrayList[index]){
			if(!dfs(graphArrayList, visited, next, -color)){
				return false;
			}
		}
		return true;
	}
}
