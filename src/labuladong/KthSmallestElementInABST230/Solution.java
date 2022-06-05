package labuladong.KthSmallestElementInABST230;

import 每日一题.TreeNode;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class Solution {
	int count;
	int result = 0;
	public int kthSmallest(TreeNode root, int k) {
		count = k;
		traverse(root);
		return result;
	}

	public void traverse(TreeNode root){
		if(root==null){
			return ;
		}
		traverse(root.left);
		count--;
		if(count==0){
			result = root.val;
			return;
		}
		traverse(root.right);
	}
}
