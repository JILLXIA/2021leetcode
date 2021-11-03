package 每日一题.接雨水42;

public class Solution1 {
	// 事实上我们并不需要关心较大一边的最大值是多少，只需要知道较小一边的最大值就好了
	public int trap(int[] height) {
		int leftMax = height[0];
		int rightMax = height[height.length-1];
		int sum = 0;
		int left = 0;
		int right = height.length-1;
		while(left<right){
			if(leftMax<rightMax){
				sum = sum + leftMax - height[left];
				left++;
				leftMax = Math.max(leftMax,height[left]);
			}else{
				sum = sum + rightMax - height[right];
				right--;
				rightMax = Math.max(rightMax,height[right]);
			}
		}
		return sum;
	}
}
