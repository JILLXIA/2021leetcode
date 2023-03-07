package ProgrammerCarl.SymmetricTree101;

import 树.TreeNode;

public class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        // 用recursive的做法
        if(root == null){
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if(left == null && right != null){
            return false;
        } else if(left != null && right == null){
            return false;
        } else if(left == null && right == null){
            return true;
        } else if(left.val != right.val){
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
