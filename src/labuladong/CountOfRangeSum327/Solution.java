package labuladong.CountOfRangeSum327;

/**
 * Given an integer array nums and two integers lower and upper,
 * return the number of range sums that lie in [lower, upper] inclusive.
 *
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices
 * i and j inclusive, where i <= j.
 */
public class Solution {
	int lower;
	int upper;
	long[] preSum;
	long[] tmp;
	int result = 0;
	public int countRangeSum(int[] nums, int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
		preSum = new long[nums.length+1];
		tmp = new long[nums.length+1];
		for(int i = 0;i< nums.length;i++){
			preSum[i+1] = preSum[i]+(long)nums[i];
		}
		sort(0, preSum.length-1);
		return result;
	}

	public void sort(int low, int high){
		if(low >= high){
			return;
		}
		int mid = low + (high - low)/2;
		sort(low, mid);
		sort(mid+1,high);
		merge(low, mid, high);
	}

	public void merge(int low, int mid, int high){
			for(int i = low; i<=high;i++){
				tmp[i] = preSum[i];
			}
			// 合并数组之前加一点私货， 算出result
			// 维护左闭右开区间[start, end)中的元素和nums[i]差在lower和upper之间
		  int start = mid + 1;
			int end = mid + 1;
			for(int i = low; i<=mid; i++){
				while(start <= high && preSum[start] - preSum[i] < lower){
					start++;
				}
				while(end <= high && preSum[end] - preSum[i] <= upper){
					end++;
				}
				result += end - start;
			}
		int lowIndex = low;
		int highIndex = mid+1;
		int currIndex = low;
		while(lowIndex<=mid || highIndex<=high){
			if(lowIndex>mid){
				preSum[currIndex] = tmp[highIndex];
				highIndex++;
			} else if(highIndex>high){
				preSum[currIndex] = tmp[lowIndex];
				lowIndex++;
			}else{
				if(tmp[lowIndex]<=tmp[highIndex]){
					preSum[currIndex] = tmp[lowIndex];
					lowIndex++;
				}else{
					preSum[currIndex] = tmp[highIndex];
					highIndex++;
				}
			}
			currIndex++;
		}

	}
}
