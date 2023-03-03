package ProgrammerCarl.BinaryTreePreorderTraversal144;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree,
 * return the preorder traversal of its nodes' values.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> result){
        if(root == null){
            return ;
        }
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }
}
