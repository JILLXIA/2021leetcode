package ProgrammerCarl.SameTree100;

import 树.TreeNode;

/**
 * Given the roots of two binary trees p and q,
 * write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are
 * structurally identical, and the nodes have the same value.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q != null){
            return false;
        } else if(p!=null && q == null){
            return false;
        } else if(p==null && q == null){
            return true;
        } else if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
