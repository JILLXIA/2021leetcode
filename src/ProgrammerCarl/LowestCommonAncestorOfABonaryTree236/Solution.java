package ProgrammerCarl.LowestCommonAncestorOfABonaryTree236;

import 树.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class Solution {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestor(root, p, q);
        return result;
    }

    public int ancestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.val == p.val || root.val == q.val){
            count++;
        }
        int left = ancestor(root.left, p,q);
        int right = ancestor(root.right, p, q);

        if(result ==  null && count + left + right >= 2){
            result = root;
        }
        return count + left + right;
    }
}
