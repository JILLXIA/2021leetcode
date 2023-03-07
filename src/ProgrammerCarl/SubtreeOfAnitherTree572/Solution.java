package ProgrammerCarl.SubtreeOfAnitherTree572;

import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same
 * structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists
 * of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 */
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode curr = root;
        while(!deque.isEmpty() || curr != null){
            if(checkSameTree(curr,subRoot)){
                return true;
            }
            if(curr != null){
                deque.offerLast(curr);
                curr = curr.left;
            } else {
                curr = deque.pollLast();
                curr = curr.right;
            }
        }
        return false;
    }

    public boolean checkSameTree(TreeNode p, TreeNode q){
        if(p == null && q != null){
            return false;
        } else if(p != null && q == null){
            return false;
        } else if(p == null && q == null){
            return true;
        } else if(p.val != q.val){
            return false;
        }
        return checkSameTree(p.left, q.left) && checkSameTree(p.right, q.right);
    }
}
