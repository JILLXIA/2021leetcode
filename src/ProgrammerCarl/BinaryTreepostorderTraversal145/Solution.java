package ProgrammerCarl.BinaryTreepostorderTraversal145;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree,
 * return the postorder traversal of its nodes' values.
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    public void traversal(TreeNode root, List<Integer> result){
        if(root == null){
            return ;
        }

        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }
}
