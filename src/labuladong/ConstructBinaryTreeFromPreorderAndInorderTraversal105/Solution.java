package labuladong.ConstructBinaryTreeFromPreorderAndInorderTraversal105;

import 每日一题.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
// Arrays.copyOfRange是开辟一个新数组，会增加空间复杂度，直接用index来控制数组访问的位置
public class Solution {
	HashMap<Integer,Integer> inOrderIndex = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder){
		for(int i = 0;i<inorder.length;i++){
			inOrderIndex.put(inorder[i],i);
		}
		return realBuildTree(preorder,0, preorder.length-1,inorder,0,inorder.length-1);
	}
	public TreeNode realBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if(preStart > preEnd || inStart > inEnd){
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIndex = inOrderIndex.get(preorder[preStart]);
		root.left = realBuildTree(preorder,preStart+1,preStart + rootIndex - inStart, inorder,inStart, rootIndex-1);
		root.right = realBuildTree(preorder,preStart + rootIndex - inStart +1,preEnd,inorder,rootIndex+1,inEnd);
		return root;
	}
	public static void main(String[] args){
		Solution s = new Solution();
		s.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,29,7});
	}
}
