package labuladong.SortAnArray912;

import java.util.Random;

/**
 * Given an array of integers nums, sort the array in ascending order.
 */
public class Solution1 {
	// quik sort
	int[] nums;
	public int[] sortArray(int[] nums) {
		this.nums = nums;
		shuffle();
		sort(0, nums.length-1);
		return this.nums;
	}

	public void shuffle(){
		Random rd = new Random();
		for(int i = 0;i < nums.length;i++){
			int index = i + rd.nextInt(nums.length-i);
			swap(i, index);
		}
	}

	public void sort(int low, int high){
		if(low >= high){
			return ;
		}
		int i = partition(low, high);
		sort(low,i-1);
		sort(i+1,high);
	}

	public int partition(int low, int high){
		int pivot = nums[low];
		// [low, i) <= pivot  (j,high] > pivot
		// 要保证[low, high]的区间都被覆盖到
		int i = low + 1;
		int j = high;
		while(i<=j){
			while(i<high && nums[i] <= pivot){
				i++;
			}
			while(j>low && nums[j] > pivot){
				j--;
			}

			if(i>=j){
				break;
			}
			swap(i,j);
		}
		swap(low,j); // j 不可以替换为i-1,因为j 和 i有可能相等
		return j;
	}

	public void swap(int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
