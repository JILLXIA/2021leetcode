package Grind75.LowestCommonAncestorOfABinarySearchTree235;

import 树.TreeNode;

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. p < root < q
        // 2. p == root || q == root
        // 3. p, q < root or p, q > root

        if(root == null) {
            return null;
        }

        if((root.val >= p.val && root.val <= q.val)
                || (root.val >= q.val && root.val <= p.val)){
           return root;
        } else if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }
}
