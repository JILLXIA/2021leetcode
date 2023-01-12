package Grind75.InvertBinaryTree226;

import 树.TreeNode;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }
}
