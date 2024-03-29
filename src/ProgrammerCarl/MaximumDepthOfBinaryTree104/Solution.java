package ProgrammerCarl.MaximumDepthOfBinaryTree104;

import 树.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes
 * along the longest path from the root node down to the farthest leaf node.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        // postorder
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
