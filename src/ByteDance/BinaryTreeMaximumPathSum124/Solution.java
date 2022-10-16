package ByteDance.BinaryTreeMaximumPathSum124;

import 树.TreeNode;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class Solution {
    // 求树的高度，节点和，路径长度 一般都用post recursive
    // post order recursive
    int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        post(root);
        return result;
    }

    public int post(TreeNode root){
        // post order recursive often return a integer.
        if(root==null){
            return 0;
        }

        int left = Math.max(0,post(root.left)); //
        int right = Math.max(0,post(root.right));

        // 分两种情况，当前root就是根，或者继续网上走
        result = Math.max(result, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
