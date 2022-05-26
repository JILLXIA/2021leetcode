package labuladong.DiameterOfBinaryTree543;

import 每日一题.TreeNode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class Solution {
	int result = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return result;
	}
	public int maxDepth(TreeNode root) {
		// 分解做法
		if(root==null){
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		result = Math.max(leftDepth+rightDepth,result);
		return Math.max(leftDepth,rightDepth)+1;
	}
}
//遇到子树问题，首先想到的是给函数设置返回值，然后再后续遍历上做文章
