package 每日一题.最接近的三数之和16;

import java.util.Arrays;

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。
 * 找出nums中的三个整数，使得它们的和与target最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		int b,c = 0;
		int minDiff = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(nums);// 要先排序，先排序才能用双指针
		for(int i = 0;i<nums.length-2;i++){
			b = i+1;
			c = nums.length-1;
			while(b<c){
				int temp = nums[i]+nums[b]+nums[c];
				if(temp<target){
					b++;
				}else if(temp>target){
					c--;
				}else{
					return target;
				}
				if(Math.abs(temp-target)<=minDiff){
					result = temp;
					minDiff = Math.abs(temp-target);
				}
			}
		}
		return result;
	}
	public static void main(String[] args){
		Solution s = new Solution();
		int[] arr = new int[]{-1,2,1,-4};
		s.threeSumClosest(arr,1);
	}
}
