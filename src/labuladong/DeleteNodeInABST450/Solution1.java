package labuladong.DeleteNodeInABST450;

import 每日一题.TreeNode;

public class Solution1 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root==null){
			return null;
		}
		if(root.val==key){
			// delete this node
			if(root.left==null){
				return root.right;
			}
			if(root.right==null){
				return root.left;
			}
			TreeNode curr = root.right;
			while(curr.left!=null){
				curr = curr.left;
			}
			root.right = deleteNode(root.right, curr.val);
			curr.left = root.left;
			curr.right = root.right;
			root = curr;

		} else if(root.val < key){
			root.right = deleteNode(root.right,key);
		} else {
			root.left = deleteNode(root.left,key);
		}
		return root;
	}
}
