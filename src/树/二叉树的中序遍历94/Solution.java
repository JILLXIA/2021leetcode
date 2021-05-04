package 树.二叉树的中序遍历94;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 左子树-》中间节点-》右子树
 */
public class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}
