package labuladong.ConstructBinaryTreeFromPreorderAndPostorderTraversal889;

import 每日一题.TreeNode;

import java.util.HashMap;

/**
 * Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
 *
 * If there exist multiple answers, you can return any of them.
 */
public class Solution {
	HashMap<Integer, Integer> map = new HashMap<>();
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		for(int i = 0;i< postorder.length;i++){
			map.put(postorder[i],i);
		}
		return build(preorder,0,preorder.length-1, postorder,0, postorder.length-1);
	}

	public TreeNode build(int[] preorder, int preStart, int preEnd,
												int[] postorder, int postStart, int postEnd){
		if(preStart > preEnd || postStart > postEnd || preStart >= preorder.length
		|| postStart >= postorder.length){
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		if(preStart < preEnd){
			int leftValue = preorder[preStart+1];
			int postLeftIndex = map.get(leftValue);
			int leftLength = postLeftIndex - postStart+1;
			root.left = build(preorder,preStart+1,preStart+leftLength,
					postorder, postStart,postLeftIndex);
			root.right = build(preorder, preStart+leftLength+1,preEnd,
					postorder,postLeftIndex+1,postEnd-1);
		}
		return root;

	}
}
