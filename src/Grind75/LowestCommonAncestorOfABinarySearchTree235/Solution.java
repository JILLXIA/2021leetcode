package Grind75.LowestCommonAncestorOfABinarySearchTree235;

import 树.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that
 * has both p and q as descendants (where we allow a node
 * to be a descendant of itself).”
 */
// this solution can solve the common scenario, despite the tree is not BST
public class Solution {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, p, q);
        return result;
    }

    public int findNode(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return 0;
        }

        int value = (root.val == p.val || root.val == q.val) ? 1 : 0;

        int leftValue = findNode(root.left, p, q);
        int rightValue = findNode(root.right, p, q);

        if(result == null && value + leftValue + rightValue == 2){
            result = root;
        }

        return value + leftValue + rightValue;
    }
}
