package 每日一题.二叉搜索树中的搜索700;

import 每日一题.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val==val){
            return root;
        }else if(root.val<val){
            return searchBST(root.right,val);
        }else if(root.val>val){
            return searchBST(root.left,val);
        }
        return null;
    }
}
