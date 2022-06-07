package labuladong.SearchInABinarySearchTree700;

import 每日一题.TreeNode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 */
public class Solution {
	public TreeNode searchBST(TreeNode root, int val) {
		if(root==null){
			return null;
		}

		int rootval = root.val;
		if(rootval==val){
			return root;
		} else if(rootval<val){
			return searchBST(root.right,val);
		} else{
			return searchBST(root.left,val);
		}
	}
}
