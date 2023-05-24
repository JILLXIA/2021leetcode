package ProgrammerCarl.PathSum112;

import 树.TreeNode;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class Solution {

    int sum = 0;
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    public void dfs(TreeNode root, int targetSum) {
        if(result) {
            return;
        }
        if(root == null){
            return;
        }
        // val不一定是正数
        sum += root.val;
        if(sum == targetSum && root.left==null && root.right==null){
            result = true;
        } else {
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
        }

        sum -= root.val;
    }
}
