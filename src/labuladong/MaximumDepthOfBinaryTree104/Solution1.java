package labuladong.MaximumDepthOfBinaryTree104;

import 每日一题.TreeNode;

public class Solution1 {
	public int maxDepth(TreeNode root) {
		// 分解做法
		if(root==null){
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return Math.max(leftDepth,rightDepth)+1;
	}
}
