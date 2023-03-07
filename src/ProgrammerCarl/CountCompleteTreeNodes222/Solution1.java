package ProgrammerCarl.CountCompleteTreeNodes222;

import 树.TreeNode;

public class Solution1 {
    public int countNodes(TreeNode root) {
        // find left depth and right depth of the complete tree
        // logn * logn
        if(root == null){
            return 0;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int leftDepth = 0;
        int rightDepth = 0;

        while(leftNode != null){
            leftNode = leftNode.left;
            leftDepth++;
        }

        while(rightNode != null){
            rightNode = rightNode.right;
            rightDepth++;
        }

        if(leftDepth == rightDepth){
            return (2 << leftDepth) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
