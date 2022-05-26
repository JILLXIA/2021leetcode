package labuladong.MaximumDepthOfBinaryTree104;

import 每日一题.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Solution {
	// 遍历方法
	int depth = 0;
	int result = 0;
	public int maxDepth(TreeNode root) {
		if(root==null){
			return result;
		}
		depth++;
		maxDepth(root.left);
		maxDepth(root.right);
		result = Math.max(result,depth);
		depth--;
		return result;
	}
}
