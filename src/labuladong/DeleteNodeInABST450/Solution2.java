package labuladong.DeleteNodeInABST450;

import 树.TreeNode;

public class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val == key) {
            root = delete(root);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode delete(TreeNode root) {
        TreeNode tmpLeft = root.left;

        if(root.right == null) {
            return root.left;
        } else {
            TreeNode curr = root.right;
            // find right left most

            while(curr.left != null) {
                curr = curr.left;
            }

            curr.left = tmpLeft;
            root = root.right;
        }
        return root;
    }
}
