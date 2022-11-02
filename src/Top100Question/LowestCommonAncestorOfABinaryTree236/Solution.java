package Top100Question.LowestCommonAncestorOfABinaryTree236;

import 树.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA)
 * of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two
 * nodes p and q as the lowest node in T that has both p and q as
 * descendants (where we allow a node to be a descendant of itself).”
 */
public class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findTree(root, p, q);
        return result;
    }

    public int findTree(TreeNode root, TreeNode p, TreeNode q){
        // 查看这个子树是否包含p和q
        // 需要保证每一个节点的值是unique的
        if(root==null){
            return 0;
        }
        int left = findTree(root.left, p, q);
        int right = findTree(root.right, p, q);
        int self = 0;
        if(root.val==p.val || root.val==q.val){
            self = 1;
        }

        int count = left + right + self;
        if(count==2 && result==null){
            result = root;
        }
        return count;
    }
}
