package 树.路径总和112;

import 树.TreeNode;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class Solution {
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        calPath(root,targetSum,root.val);
        return result;
    }

    public void calPath(TreeNode root, int targetSum, int curSum){
        if(result){
            return;
        }
        if(curSum==targetSum && root.left==null&&root.right==null){
            //注意修改条件的情况是在遍历到叶节点的时候
            result = true;
            return;
        }
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        if(root.left!=null){
            calPath(root.left,targetSum,curSum+root.left.val);
        }

        if(root.right!=null){
            calPath(root.right,targetSum,curSum+root.right.val);
        }
    }

}
