package labuladong.InsertIntoABinarySearchTree701;

import 每日一题.TreeNode;

public class Solution1 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		// 稍微brief一点的解法
		if(root==null){
			return new TreeNode(val);
		}
		if(root.val > val){
			root.left = insertIntoBST(root.left,val);
		} else {
			root.right = insertIntoBST(root.right,val);
		}
		return root;
	}
}
