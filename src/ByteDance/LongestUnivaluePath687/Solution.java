package ByteDance.LongestUnivaluePath687;

import 树.TreeNode;

/**
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
 *
 * The length of the path between two nodes is represented by the number of edges between them.
 */
public class Solution {
    int result;
    public int longestUnivaluePath(TreeNode root) {
        result = 0;
        postOrder(root);
        return result;
    }

    public int postOrder(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        int arrowLeft = 0;
        int arrowRight = 0;
        if(root.left!=null && root.left.val == root.val){
            arrowLeft = left + 1;
        }
        if(root.right!=null && root.right.val == root.val){
            arrowRight = right + 1;
        }
        result = Math.max(result, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
