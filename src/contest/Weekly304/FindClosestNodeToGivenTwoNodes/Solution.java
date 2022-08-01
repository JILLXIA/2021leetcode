package contest.Weekly304.FindClosestNodeToGivenTwoNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	public int closestMeetingNode(int[] edges, int node1, int node2) {
		HashMap<Integer, Integer> indexToPath1 = new HashMap<>();
		HashSet<Integer> path2 = new HashSet<>();
		int curr = node1;
		int path = 0;
		while(curr!=-1 && !indexToPath1.containsKey(curr)){
			indexToPath1.put(curr,path);
			curr = edges[curr];
			path++;
		}

		curr = node2;
		path = 0;
		int resultNode = Integer.MAX_VALUE;
		int resultValue = Integer.MAX_VALUE;
		while (curr!=-1 && !path2.contains(curr)){
			path2.add(curr);
			if(!indexToPath1.containsKey(curr)){
				curr = edges[curr];
				path++;
				continue;
			}

			int value = Math.max(path, indexToPath1.get(curr));
			if(value < resultValue){
				resultNode = curr;
				resultValue = value;
			} else if(value==resultValue){
				resultNode = Math.min(curr,resultNode);
			}
			curr = edges[curr];
			path++;
		}
		return resultNode==Integer.MAX_VALUE ? -1:resultNode;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.closestMeetingNode(new int[]{4,4,4,5,1,2,2},1,1));
	}
}
