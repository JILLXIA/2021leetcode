package labuladong.UniqueBinarySearchTrees96;

/**
 * Given an integer n,
 * return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 */
public class Solution {
	int[][] memo;
	public int numTrees(int n) {
		memo = new int[n+2][n+2];
		return count(1, n);
	}

	public int count(int low, int high){
		if(low > high){
			return 1;
		}
		if(memo[low][high]!=0){
			return memo[low][high];
		}
		int result = 0;
		for(int i = low; i<=high;i++){
			memo[low][i-1] = count(low, i-1);
			memo[i+1][high] = count(i+1, high);
			result += memo[low][i-1] * memo[i+1][high];
		}
		memo[low][high] = result;
		return result;
	}
}
