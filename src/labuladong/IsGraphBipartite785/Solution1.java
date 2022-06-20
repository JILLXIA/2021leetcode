package labuladong.IsGraphBipartite785;

import java.util.Deque;
import java.util.LinkedList;

// BFS 解法
public class Solution1 {
	public boolean isBipartite(int[][] graph) {
		int[] isVisited = new int[graph.length];


		for(int i = 0;i< graph.length;i++){
			if(isVisited[i]==0){
				Deque<Integer> deque = new LinkedList<>();
				deque.offerLast(i);
				isVisited[i] = 1;
				while(!deque.isEmpty()){
					int tmp = deque.pollFirst();
					for(int k:graph[tmp]){
						if(isVisited[k]==isVisited[tmp]){
							return false;
						}
						if(isVisited[k]==0) {
							deque.offerLast(k);
							isVisited[k] = -isVisited[tmp];
						}
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args){
		Solution1 s = new Solution1();
		s.isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}});
	}
}
