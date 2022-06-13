package labuladong.MaximumSumBSTInBinaryTree1373;

import javafx.util.Pair;
import 每日一题.TreeNode;

/**
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class Solution {
	// 1. 左右子树是否为BST
	// 2. 左右子树加上自身是否为BST（左子树的最大值，右子树的最小值）
	// 3. 左右子树的和
	int result = 0;
	public int maxSumBST(TreeNode root) {
		maxSum(root);
		return result;
	}

	// res[0] 以root为根的二叉树是否为BST 1是0不是
	// res[1] 以root为BST根节点左子树的最大值
	// res[2] 以root为BST根节点右子树的最小值
	// res[3] 以root为根节点的子树和
	public int[] maxSum(TreeNode root){
		if(root==null){
			return new int[]{1,Integer.MIN_VALUE, Integer.MAX_VALUE,0};
		}

		int[] leftTree = maxSum(root.left);
		int[] rightTree = maxSum(root.right);

		if(leftTree[0]==1 && rightTree[0]==1 && root.val > leftTree[1] && root.val < rightTree[2]){
			int sum = root.val + leftTree[3] + rightTree[3];
			result = Math.max(result,sum);
			// root为左子树的最大值
			int leftMax = Math.max(root.val,rightTree[1]);
			int rightMin = Math.min(root.val,leftTree[2]);
			return new int[]{1,leftMax,rightMin,sum};
		} else {
			return new int[]{0,0,0,0};
		}
	}

}
