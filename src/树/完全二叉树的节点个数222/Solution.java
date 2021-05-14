package 树.完全二叉树的节点个数222;

import 树.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~2h个节点。
 */
public class Solution {
    public int countNodes(TreeNode root) {
        /**
         * 用类似二分法的办法，比较左右子树的深度
         * 如果左边深度和右边相等，就递归找右边，如果不想等就递归找左边
         */
        if(root==null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left==right){
            return countNodes(root.right)+(1<<left);
            //完全二叉树可以想到位运算
        }else{
            return countNodes(root.left)+(1<<right);
        }
    }

    public int countLevel(TreeNode root){
        if(root==null){
            return 0;
        }
        int result = 0;
        while(root!=null){
            result++;
            root = root.left;
        }
        return result;
    }
}
