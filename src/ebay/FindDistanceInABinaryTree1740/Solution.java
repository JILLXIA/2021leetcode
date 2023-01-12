package ebay.FindDistanceInABinaryTree1740;

import 树.TreeNode;

/**
 * Given the root of a binary tree and two integers p and q,
 * return the distance between the nodes of value p and value q in the tree.
 *
 * The distance between two nodes is the number of edges
 * on the path from one to the other.
 */
public class Solution {
    TreeNode lca = null;
    public int findDistance(TreeNode root, int p, int q) {
        // find common ancester
        findLowestAncester(root, p,q);
        int h1 = dist(lca, p,0);
        int h2 = dist(lca, q, 0);
        return h1 + h2;
    }

    public int dist(TreeNode root, int p, int index){
        if(root==null){
            return 0;
        }

        if(root.val==p){
            return index;
        }

        int left = dist(root.left, p,index + 1);
        if(left!=0){
            return left;
        } else {
            return dist(root.right, p,index + 1);
        }
    }

    public int findLowestAncester(TreeNode root, int p, int q){
        if(root==null){
            return 0;
        }

        int left = findLowestAncester(root.left, p,q);
        int right = findLowestAncester(root.right, p,q);

        int self = (root.val==p || root.val==q) ? 1 : 0;

        if(left + right + self==2 && lca==null){
            lca = root;
        }
        return left + right + self;
    }
}
