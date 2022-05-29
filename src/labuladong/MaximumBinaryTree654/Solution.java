package labuladong.MaximumBinaryTree654;

import 每日一题.TreeNode;

import java.util.Arrays;

/**
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
 *
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 */
public class Solution {
	// 二叉树构造问题一般都是分解思路
	// 构造整棵树 = 根节点 + 构造左子树 + 构造右子树
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums.length<=0){
			return null;
		}
		int maxIndex = 0;
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0;i<nums.length;i++){
			if(maxValue<nums[i]){
				maxIndex = i;
				maxValue = nums[i];
			}
		}
		TreeNode root = new TreeNode(maxValue);
		// copyOfRange 是创建一个新数组
		root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxIndex));
		root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIndex+1,nums.length));
		return root;
	}
	public static void main(String[] args){
		int[] arr = new int[0];
		Arrays.copyOfRange(arr,0,0);
	}
}
