package contest.Weekly304.LongestCycleInAGraph;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public int longestCycle(int[] edges) {
		int n = edges.length;
		boolean[] isVisited = new boolean[n];

		int result = -1;
		for(int i = 0;i<edges.length;i++){
			HashMap<Integer,Integer> indexToPath = new HashMap<>();
			if(isVisited[i]){
				// 如果这个点已经遍历过了，就一定不从这个地方开始
				continue;
			}
			int curr = i;
			int path = 0;
			while(curr!=-1 && !indexToPath.containsKey(curr)){
				if(isVisited[curr]){
					curr=-1;
					break;
				}
				// 如果没有走到底，或者没有成环
				isVisited[curr] = true;
				indexToPath.put(curr,path);
				curr = edges[curr];
				path++;
			}
			if(curr!=-1){
				// 成环了
				result = Math.max(result,path - indexToPath.get(curr));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestCycle(new int[]{3,3,4,2,3}));
	}
}
