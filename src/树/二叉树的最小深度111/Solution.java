package 树.二叉树的最小深度111;

import 树.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 不要在递归的参数里面用i++,++i这样原来作用域的参数也被改变了，无法回溯
 */
public class Solution {
    int result = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        countDepth(root,1);
        return result;
    }

    public void countDepth(TreeNode root,int depth){

        if(root.left==null && root.right==null){
            result = Math.min(result,depth);
            return ;
        }

        if(depth>=result){
            return;
        }

        if(root==null){
            return;
        }

        if(root.left!=null){
            depth++;
            countDepth(root.left,depth);
            depth--;
        }

        if(root.right!=null){
            depth++;
            countDepth(root.right,depth);
            depth--;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        Solution s = new Solution();
        System.out.println(s.minDepth(root));

    }
}
