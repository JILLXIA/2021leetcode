package 每日一题.K个逆序对数组629;

/**
 * 给出两个整数n和k，找出所有包含从1到n的数字，
 * 且恰好拥有k个逆序对的不同的数组的个数。
 *
 * 逆序对的定义如下：对于数组的第i个和第j个元素，
 * 如果满i<j且a[i]>a[j]，则其为一个逆序对；否则不是。
 *
 * 由于答案可能很大，只需要返回 答案 mod 109+ 7 的值。
 */
public class Solution {
	public int kInversePairs(int n, int k) {
		// 利用二维dp来解题
		int mod = (int)1e9+7;
		int[][] dp = new int[n+1][k+1];
		for(int i = 1;i<dp.length;i++){
			dp[i][0] = 1;
		}


		for(int i = 1;i<dp.length;i++){
			for(int j = 1;j<dp[0].length;j++){
				for(int x = 1;x<=i;x++){
					if(j-i+x>=0) {
						dp[i][j] = (dp[i][j] + dp[i - 1][j - i + x])%mod;
					}
				}
			}
		}
		return dp[n][k];
	}
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.kInversePairs(3,1));
	}
}
