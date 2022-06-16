package labuladong.KthLargestElementInAnArray215;

import java.util.Random;

// 也可以用快速排序的思想进行解答
// 找升序排列 n-k个元素
// 快速排序partiton函数知道某一个点的排名
public class Solution1 {
	int[] arr;
	public int findKthLargest(int[] nums, int k) {
		arr = nums;
		k = nums.length - k;
		shuffle();
		int low = 0;
		int high = arr.length-1;

		while(low <= high){
			int index = partition(low,high);
			if(index==k){
				return arr[k];
			} else if(index < k){
				low = index + 1;
			} else {
				high = index - 1;
			}
		}
		return -1;
	}

	public int partition(int low, int high){
		int pivot = arr[low];
		int i = low + 1;
		int j = high;
		// [low, i)  (j, high]
		while(i<=j){
			while(i < high && arr[i]<=pivot){
				i++;
			}
			while(j > low && arr[j] > pivot){
				j--;
			}
			if(i >= j){
				break;
			}
			swap(i,j);
		}
		swap(low,j);
		return j;
	}
	public void shuffle(){
		// 洗牌算法，打乱arr
		Random rd = new Random();
		for(int i = 0;i<arr.length;i++){
			int index = i + rd.nextInt(arr.length-i);
			swap(i,index);
		}
	}

	public void swap(int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
