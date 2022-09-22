package Google.FindLeavesOfBinaryTree366;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        // 问题转化为求子树的高度
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,root);
        return result;
    }
    public int dfs(List<List<Integer>> result, TreeNode root){
        if(root==null){
            return 0;
        }
        int height = 1 + Math.max(dfs(result,root.left),dfs(result,root.right));
        if(height>=result.size()){
            result.add(new ArrayList<>());
        }
        result.get(height-1).add(root.val);
        return height;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}