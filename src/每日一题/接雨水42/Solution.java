package 每日一题.接雨水42;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution {
	// 当前节点能存多少雨水取决于左右两边最大值 较小的那一个
	public int trap(int[] height) {
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		for(int i = 0;i<leftMax.length;i++){
			if(i==0){
				leftMax[i] = height[0];
			} else {
				leftMax[i] = Math.max(leftMax[i - 1], height[i]);
			}
		}
		for(int i = rightMax.length-1;i>=0;i--){
			if(i==rightMax.length-1){
				rightMax[i] = height[rightMax.length-1];
			} else {
				rightMax[i] = Math.max(rightMax[i + 1], height[i]);
			}
		}
		int sum = 0;
		for(int i = 0;i<height.length;i++){
			sum = sum + Math.min(leftMax[i],rightMax[i]) - height[i];
		}
		return sum;
	}
}
