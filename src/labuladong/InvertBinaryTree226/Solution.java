package labuladong.InvertBinaryTree226;

import 每日一题.TreeNode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if(root==null){
			return null;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
