package Top100Question.LowestCommonAncestorOfABinarySearchTree235;

import 树.TreeNode;

/**
 * Given a binary search tree (BST),
 * find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “
 * The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class Solution {
    TreeNode result = null; // 可以用pre order
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findTree(root,p,q);
        return result;
    }

    public void findTree(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || result != null){
            return;
        }
        if((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)
                || (p.val==root.val) || (q.val==root.val) || root==null){
            result = root;
            return;
        }

        if(p.val > root.val){
            findTree(root.right,p,q);
        } else if(p.val < root.val){
            findTree(root.left,p,q);
        }

    }
}
