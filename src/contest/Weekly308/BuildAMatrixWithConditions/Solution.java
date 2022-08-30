package contest.Weekly308.BuildAMatrixWithConditions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
	public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
		ArrayList<Integer>[] row = new ArrayList[k+1];
		ArrayList<Integer>[] col = new ArrayList[k+1];
		int[] inDegreeRow = new int[k+1];
		int[] inDegreeCol = new int[k+1];
		for(int i = 0;i<=k;i++){
			row[i] = new ArrayList<>();
			col[i] = new ArrayList<>();
		}
		for(int[] rowItem:rowConditions){
			row[rowItem[0]].add(rowItem[1]);
			inDegreeRow[rowItem[1]]++;
		}
		for(int[] colItem:colConditions){
			col[colItem[0]].add(colItem[1]);
			inDegreeCol[colItem[1]]++;
		}
		Deque<Integer> dequeRow = new LinkedList<>();
		Deque<Integer> dequeCol = new LinkedList<>();
		for(int i = 1;i<=k;i++){
			if(inDegreeRow[i]==0){
				dequeRow.offerLast(i);
			}
			if(inDegreeCol[i]==0){
				dequeCol.offerLast(i);
			}
		}
		ArrayList<Integer> resultRow = new ArrayList<>();
		HashMap<Integer,Integer> resultCol = new HashMap<>();
		while(!dequeRow.isEmpty()){
			int tmp = dequeRow.pollFirst();
			resultRow.add(tmp);
			for(int i:row[tmp]){
				inDegreeRow[i]--;
				if(inDegreeRow[i]<=0){
					dequeRow.offerLast(i);
				}
			}
		}

		while(!dequeCol.isEmpty()){
			int tmp = dequeCol.pollFirst();
			resultCol.put(tmp,resultCol.size());
			for(int i:col[tmp]){
				inDegreeCol[i]--;
				if(inDegreeCol[i]<=0){
					dequeCol.offerLast(i);
				}
			}
		}
		if(resultCol.size()!=k||resultRow.size()!=k){
			return new int[][]{};
		}
		int[][] result = new int[k][k];
		for(int i = 0;i<k;i++){
			result[i][resultCol.get(resultRow.get(i))] = resultRow.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.buildMatrix(3,new int[][]{{1,2},{3,2}},new int[][]{{2,1},{3,2}}));
	}
}
