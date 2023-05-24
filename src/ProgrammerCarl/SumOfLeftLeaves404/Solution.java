package ProgrammerCarl.SumOfLeftLeaves404;

import 树.TreeNode;

/**
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * A leaf is a node with no children.
 * A left leaf is a leaf that is the left child of another node.
 */
public class Solution {
    int result = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        checkLeftLeaves(root, -1);
        return result;
    }

    public void checkLeftLeaves(TreeNode root, int direction){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            // leaves
            if(direction==1){
                result += root.val;
            } else {
                return;
            }
        }

        checkLeftLeaves(root.left, 1);
        checkLeftLeaves(root.right, -1);
    }
}
