package Grind75.BalancedBinaryTree110;

import 树.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 */
public class Solution {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        countHeight(root);
        return result;
    }

    public int countHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = countHeight(root.left);
        int right = countHeight(root.right);

        if(Math.abs(left - right) > 1){
            result = false;
        }
        return Math.max(left, right) + 1;
    }
}
