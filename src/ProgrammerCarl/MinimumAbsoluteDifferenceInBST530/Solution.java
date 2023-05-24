package ProgrammerCarl.MinimumAbsoluteDifferenceInBST530;

import 树.TreeNode;

/**
 * Given the root of a Binary Search Tree (BST),
 * return the minimum absolute difference between the values of
 * any two different nodes in the tree.
 */
public class Solution {
    TreeNode pre;
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) {
            return Math.min(result, Integer.MAX_VALUE);
        }

        getMinimumDifference(root.left);
        if(pre != null){
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        getMinimumDifference(root.right);
        return result;
    }
}
