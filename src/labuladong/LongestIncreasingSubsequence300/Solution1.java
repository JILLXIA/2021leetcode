package labuladong.LongestIncreasingSubsequence300;

public class Solution1 {
	// patience sorting
	public int lengthOfLIS(int[] nums) {
		// 1. We need to work through the cards from left to right as we go through the deck,
		// eventually dividing the cards into piles
		// 2. He can only press the smaller card into the bigger card;
		// If the number of current cards is large and there is no pile to place,
		// then create a new pile and put the card in it.

		// If the current card has more than one pile to choose from,
		// then choose the leftmost pile to place.
		// 3. The final pile of cards is the maximum increasing subsequence length.
		int[] top = new int[nums.length];
		int piles = 0;
		for(int i = 0;i<nums.length;i++){
			int left = 0;
			int right = piles;
			int poker = nums[i];
			while(left < right){
				int mid = left + (right-left)/2;
				if(top[mid] > poker){
					right = mid;
				}else if(top[mid]==poker){
					right = mid;
				}else {
					left = mid + 1;
				}
			}
			if(left==piles){
				piles++;
			}
			top[left] = poker;
		}
		return piles;
	}
}
