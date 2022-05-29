package labuladong.FlattenBinaryTreeToLinkedList114;

import 每日一题.TreeNode;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
public class Solution {
	public void flatten(TreeNode root) {
		// 先将左子树变成右子树
		// 再将右子树贴到左子树的下方
		if(root==null){
			return;
		}
		flatten(root.left);
		flatten(root.right);

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = null;
		root.right = left;
		TreeNode p = root;
		while(p.right != null){
			p = p.right;
		}
		p.right = right;
	}
}
