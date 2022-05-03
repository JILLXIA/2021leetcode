package labuladong.TwoSumIIInputArrayIsSorted167;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2,
 * added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 */
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int startIndex = 0;
		int endIndex = numbers.length - 1;
		int curr = 0;
		while(startIndex < endIndex){
			curr = numbers[startIndex] + numbers[endIndex];
			if(curr == target){
				return new int[]{startIndex+1,endIndex+1};
			} else if(curr < target){
				startIndex++;
			} else if(curr > target){
				endIndex--;
			}
		}
		return null;
	}
}
