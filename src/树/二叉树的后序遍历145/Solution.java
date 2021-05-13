package 树.二叉树的后序遍历145;

import 树.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.offerLast(root);
                result.add(root.val);
                root = root.right;
            }
            TreeNode tmp = stack.pollLast();
            root = tmp.left;
        }
        Collections.reverse(result);
        return result;
    }
}
