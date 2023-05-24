package ProgrammerCarl.ValidateBinarySearchTree98;

import 树.TreeNode;

import java.util.ArrayList;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class Solution {
    // sorted -> inorder traverse is ordered
    ArrayList<Integer> inorder = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inorder(root);

        // check the order is sorted
        for(int i = 1;i<inorder.size();i++){
            if(inorder.get(i) <= inorder.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
}
