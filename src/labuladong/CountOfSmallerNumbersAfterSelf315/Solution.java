package labuladong.CountOfSmallerNumbersAfterSelf315;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new
 * counts array. The counts array has the property where counts[i] is
 * the number of smaller elements to the right of nums[i].
 */
public class Solution {
	// 归并排序 merge的时候是可以知道有多少元素比当前小的
	int[] count;
	Pair[] tmp; // 辅助数组
	Pair[] arr; // 标记原数组的index，相当于将nums转化为Pair的形势
	public List<Integer> countSmaller(int[] nums) {
		count = new int[nums.length];
		tmp = new Pair[nums.length];
		arr = new Pair[nums.length];
		for(int i = 0;i< nums.length;i++){
			arr[i] = new Pair(nums[i],i);
			tmp[i] = new Pair(nums[i],i);
		}
		sort(0, nums.length-1);
		List<Integer> result = new ArrayList<>();
		for(int i = 0;i<count.length;i++){
			result.add(count[i]);
		}
		return result;
	}

	public void sort(int low, int high){
		if(low >= high){
			return;
		}
		int mid = low + (high-low)/2;
		sort(low,mid);
		sort(mid+1,high);
		merge(low,mid,high);
	}

	public void merge(int low, int mid, int high){
		// 对arr重新进行排序
		// 初始化辅助数组
		for(int i = low;i<=high;i++){
			tmp[i].setValue(arr[i].getValue());
			tmp[i].setIndex(arr[i].getIndex());
		}

		int lowIndex = low;
		int highIndex = mid+1;
		int curIndex = low;
		while(lowIndex<=mid || highIndex<=high){
			if(lowIndex>mid){
				arr[curIndex].setValue(tmp[highIndex].getValue());
				arr[curIndex].setIndex(tmp[highIndex].getIndex());
				highIndex++;
			} else if(highIndex>high){
				arr[curIndex].setValue(tmp[lowIndex].getValue());
				arr[curIndex].setIndex(tmp[lowIndex].getIndex());
				count[tmp[lowIndex].getIndex()] += highIndex-mid-1;
				lowIndex++;
			} else {
				if(tmp[lowIndex].getValue() <= tmp[highIndex].getValue()){
					arr[curIndex].setValue(tmp[lowIndex].getValue());
					arr[curIndex].setIndex(tmp[lowIndex].getIndex());
					count[tmp[lowIndex].getIndex()] += highIndex-mid-1;
					lowIndex++;
				} else {
					arr[curIndex].setValue(tmp[highIndex].getValue());
					arr[curIndex].setIndex(tmp[highIndex].getIndex());
					highIndex++;
				}
			}
			curIndex++;
		}
	}
}

class Pair{
	int value;
	int index;

	public Pair(int value, int index) {
		this.value = value;
		this.index = index;
	}

	public int getValue() {
		return value;
	}

	public int getIndex() {
		return index;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}