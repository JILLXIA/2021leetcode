package labuladong.InsertIntoABinarySearchTree701;

import 每日一题.TreeNode;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */
public class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root==null){
			root = new TreeNode(val);
			return root;
		}
		if(root.val > val){
			if(root.left==null){
				root.left = new TreeNode(val);
			} else {
				insertIntoBST(root.left,val);
			}
		} else {
			if(root.right==null){
				root.right = new TreeNode(val);
			} else {
				insertIntoBST(root.right,val);
			}
		}
		return root;
	}
}
