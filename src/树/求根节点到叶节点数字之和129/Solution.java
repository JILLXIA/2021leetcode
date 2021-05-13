package 树.求根节点到叶节点数字之和129;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，
 * 树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 */
public class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            count(root,0);
            return result;
        }
    }

    public void count(TreeNode root, int tmp){
        if(root.left==null && root.right==null){
            result += tmp*10+root.val;
            return;
        }

        if(root==null){
            return;
        }
        if(root.left!=null) {
            count(root.left, tmp*10 + root.val);
        }
        if(root.right!=null) {
            count(root.right, tmp*10 + root.val);
        }
    }
}
