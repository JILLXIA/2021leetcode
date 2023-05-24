package ProgrammerCarl.PathSumII113;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values
 * in the path equals targetSum.
 * Each path should be returned as a list of the node values,
 * not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending
 * at any leaf node.
 * A leaf is a node with no children.
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    public void dfs(TreeNode root, int targetSum){
        if(root == null){
            return;
        }

        sum += root.val;
        path.add(root.val);
        if(sum == targetSum && root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        } else {
            dfs(root.left, targetSum);
            dfs(root.right, targetSum);
        }

        path.remove(path.size() - 1);
        sum -= root.val;
    }
}
