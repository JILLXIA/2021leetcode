package Grind75.DiameterOfBinaryTree543;

import 树.TreeNode;

/**
 * Given the root of a binary tree,
 * return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path
 * between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is
 * represented by the number of edges between them.
 */
public class Solution {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        postTraverse(root);
        return result-1;
    }

    public int postTraverse(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = postTraverse(root.left);
        int rightDepth = postTraverse(root.right);
        result = Math.max(result, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
