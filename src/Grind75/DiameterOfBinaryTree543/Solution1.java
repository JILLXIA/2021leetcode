package Grind75.DiameterOfBinaryTree543;

import 树.TreeNode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path
 * between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented
 * by the number of edges between them.
 */
public class Solution1 {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return result - 1;
    }

    public int postOrder(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
