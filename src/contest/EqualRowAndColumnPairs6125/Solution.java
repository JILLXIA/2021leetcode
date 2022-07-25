package contest.EqualRowAndColumnPairs6125;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public int equalPairs(int[][] grid) {
		HashMap<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		int n = grid.length;
		for(int i = 0;i< n;i++){
			StringBuilder row = new StringBuilder();
			StringBuilder coloum = new StringBuilder();
			for(int j = 0;j<n;j++){
				row.append(grid[i][j]);
				row.append(';');
				coloum.append(grid[j][i]);
				coloum.append(';');
			}

			map.put(row.toString(), map.getOrDefault(row.toString(),0)+1);
			list.add(coloum.toString());
		}
		int result = 0;
		for(int i = 0;i<list.size();i++){
			if(map.containsKey(list.get(i))){
				result += map.get(list.get(i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
	}
}
