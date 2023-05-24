package ProgrammerCarl.ValidateBinarySearchTree98;

import 树.TreeNode;

public class Solution1 {
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        // inorder record the previous node
        if(root == null){
            return true;
        }

        boolean left = isValidBST(root.left);
        if(pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
