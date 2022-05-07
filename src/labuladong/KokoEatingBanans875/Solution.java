package labuladong.KokoEatingBanans875;

/**
 * Koko loves to eat bananas. There are n piles of bananas,
 * the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k.
 * Each hour, she chooses some pile of bananas and eats k bananas
 * from that pile. If the pile has less than k bananas,
 * she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating
 * all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class Solution {
	public int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int right = 1;
		for(int pile:piles){
			right = Math.max(right,pile) + 1;
		}
		while(left < right){
			int mid = left + (right-left)/2;
			int compare = f(piles,mid);
			if(h==compare){
				right = mid;
			} else if(h<compare){
				left = mid+1;
			} else if(h>compare){
				right = mid;
			}
		}
		// 直接返回left就是左边界，这里不是数组 不用考虑数组越界的情况
		return left;
	}
	public int f(int[] piles, int k){
		// 每个小时吃k个香蕉需要多少小时
		int result = 0;
		for(int pile:piles){
			result += (pile/k) + ((pile%k!=0)?1:0);
		}
		return result;
	}
	public static void main(String[]args){
		Solution s = new Solution();
		System.out.println(s.minEatingSpeed(new int[]{3,6,7,11},8));
	}
}
