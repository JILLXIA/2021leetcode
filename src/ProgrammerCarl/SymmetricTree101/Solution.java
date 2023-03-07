package ProgrammerCarl.SymmetricTree101;

import 树.TreeNode;

import java.util.ArrayList;

/**
 * Given the root of a binary tree,
 * check whether it is a mirror of itself (i.e., symmetric around its center).
 */
// 这个做法有问题，不能用中序
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);

        // check paradromline
        int left = 0;
        int right = inorder.size()-1;
        while(left < right){
            if(inorder.get(left).equals(inorder.get(right))){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root, ArrayList<Integer> inorder){
        if(root == null){
            inorder.add(101);
            return;
        }

        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }
}
