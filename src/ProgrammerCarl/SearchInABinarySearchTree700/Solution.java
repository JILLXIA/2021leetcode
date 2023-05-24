package ProgrammerCarl.SearchInABinarySearchTree700;

import 树.TreeNode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return
 * the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        } else if(root.val == val){
            return root;
        } else if(root.val > val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
