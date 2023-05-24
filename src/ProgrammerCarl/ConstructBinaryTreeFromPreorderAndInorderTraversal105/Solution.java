package ProgrammerCarl.ConstructBinaryTreeFromPreorderAndInorderTraversal105;

import 树.TreeNode;

import java.util.HashMap;

/**
 * Given two integer arrays preorder and inorder
 * where preorder is the preorder traversal of a binary
 * tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 */
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int startPre, int endPre,
                          int startIn, int endIn){
        if(startPre > endPre || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);
        int leftLength = map.get(preorder[startPre]) - startIn;

        root.left = build(preorder, inorder, startPre + 1, startPre + leftLength, startIn, startIn + leftLength);
        root.right = build(preorder, inorder, startPre + leftLength + 1, endPre, map.get(preorder[startPre]) + 1, endIn);
        return root;
    }
}
