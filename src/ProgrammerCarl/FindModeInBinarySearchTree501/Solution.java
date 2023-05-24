package ProgrammerCarl.FindModeInBinarySearchTree501;

import 树.TreeNode;

import java.util.ArrayList;

/**
 * Given the root of a binary search tree (BST) with duplicates,
 * return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys
 * less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater
 * than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    int maxCount = 1;
    int currCount = 1;

    TreeNode pre;
    public int[] findMode(TreeNode root) {
        if(root == null){
            return null;
        }
        mode(root);
        int[] ans = new int[result.size()];
        for(int i = 0;i<ans.length;i++){
            ans[i] = result.get(i);
        }
        return ans;
    }

    public void mode(TreeNode root){
        if(root == null){
            return;
        }

        mode(root.left);
        if(pre == null){
            currCount = 1;
        }
        else {
            if(root.val == pre.val){
                currCount++;
            } else {
                currCount = 1;
            }
        }
        if(currCount > maxCount){
            maxCount = currCount;
            result = new ArrayList<>();
            result.add(root.val);
        } else if(currCount == maxCount){
            result.add(root.val);
        }
        pre = root;
        mode(root.right);
    }
}
