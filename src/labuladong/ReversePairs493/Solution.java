package labuladong.ReversePairs493;

/**
 * Given an integer array nums, return the number of reverse pairs in the array.
 *
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
 */
class Solution {
	int result = 0;
	int[] tmp;
	public int reversePairs(int[] nums) {
		tmp = new int[nums.length];
		sort(nums,0,nums.length-1);
		return result;
	}
	public void sort(int[] nums, int low,int high){
		if(low >= high){
			return;
		}
		int mid = low + (high-low)/2;
		sort(nums,low,mid);
		sort(nums,mid+1,high);
		merge(nums,low,mid,high);
	}
	public void merge(int[] nums, int low, int mid, int high){
		for(int i = low;i<=high;i++){
			tmp[i] = nums[i];
		}
		int lowIndex = low;
		int highIndex = mid+1;
		int curIndex = low;
		int highDoubleIndex = mid+1;
		while(lowIndex<=mid || highIndex<=high){
			if(lowIndex > mid){
				// 只加入右边的数组
				nums[curIndex] = tmp[highIndex];
				highIndex++;
			} else if(highIndex > high){
				nums[curIndex] = tmp[lowIndex];
				while(highDoubleIndex<=high){
					if((long)tmp[lowIndex] > (long)(2*(long)tmp[highDoubleIndex])){
						highDoubleIndex++;
					} else {
						break;
					}
				}
				result += highDoubleIndex - (mid+1);
				lowIndex++;
			} else {
				if(tmp[lowIndex]<=tmp[highIndex]){
					nums[curIndex] = tmp[lowIndex];
					while(highDoubleIndex<=high){
						if((long)tmp[lowIndex] > (long)(2*(long)tmp[highDoubleIndex])){
							highDoubleIndex++;
						} else {
							break;
						}
					}
					result += highDoubleIndex - (mid+1);
					lowIndex++;
				} else {
					nums[curIndex] = tmp[highIndex];
					highIndex++;
				}
			}
			curIndex++;
		}
	}
}