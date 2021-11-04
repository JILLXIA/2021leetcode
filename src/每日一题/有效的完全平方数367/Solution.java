package 每日一题.有效的完全平方数367;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，
 * 则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 */
public class Solution {
	public boolean isPerfectSquare(int num) {
		// 利用二分查找，是否存在 1 <= x <= num的一个数
		int left = 1;
		int right = num;
		while(left<=right){
			int mid = (left + right) / 2;
			long tmp = (long) mid * mid;
			if(tmp<num){
				left = mid + 1;
			}else if(tmp>num){
				right = mid -1;
			}else{
				return true;
			}
		}
		return false;
	}
}
