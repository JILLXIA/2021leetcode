package labuladong.ConstructBinaryTreeFromInorderAndPostorderTraversal106;

import 每日一题.TreeNode;

import java.util.HashMap;

/**
 * Given two integer arrays inorder and postorder
 * where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
 */
public class Solution {
	HashMap<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for(int i = 0;i< inorder.length;i++){
			map.put(inorder[i],i);
		}
		return build(inorder,0, inorder.length-1,postorder,0, postorder.length-1 );
	}
	public TreeNode build(int[] inorder, int inStart, int inEnd,
												int[] postorder, int postStart, int postEnd){
		if(inStart > inEnd || postStart > postEnd){
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int inorderIndex = map.get(postorder[postEnd]);
		int leftSize = inorderIndex - inStart;
		root.left = build(inorder,inStart,inStart+leftSize-1,postorder,postStart,postStart+leftSize-1);
		root.right = build(inorder, inorderIndex+1,inEnd,postorder,postStart+leftSize,postEnd-1);
		return root;
	}
}
