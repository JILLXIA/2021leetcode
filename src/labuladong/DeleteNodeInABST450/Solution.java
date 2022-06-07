package labuladong.DeleteNodeInABST450;

import 每日一题.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 */
public class Solution {
	// 注意几个点：
	// 1. 最好不要交换val值，需要操作节点的引用。需要和内部存储的数据域极结偶
	// 2. 一开始想到的是将左子树迁移到右子树最小节点下面，让右子树替换根节点，但是这样会让树的深度越来越长。
	// 3. 需要让右子树的最小值或者左子树的最大值来替换根节点
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root==null){
			return null;
		}
		if(root.val==key){
			// delete this node
			root = delete(root);
		} else if(root.val < key){
			root.right = deleteNode(root.right,key);
		} else {
			root.left = deleteNode(root.left,key);
		}
		return root;
	}

	public TreeNode delete(TreeNode root){
		TreeNode tmpLeft = root.left;
		if(root.right==null){
			root = root.left;
		} else {
			TreeNode curr = root.right;
			while(curr.left!=null){
				curr = curr.left;
			}
			curr.left = tmpLeft;
			root = root.right;
		}
		return root;
	}
}
