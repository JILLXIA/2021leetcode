package ProgrammerCarl.ConstructBinaryTreeFromInorderAndPostorder106;

import 树.TreeNode;

import java.util.HashMap;

/**
 * Given two integer arrays inorder and postorder where inorder
 * is the inorder traversal of a binary tree and postorder is the
 * postorder traversal of the same tree,
 * construct and return the binary tree.
 */
public class Solution {
    // build a map to record the node value and the index
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length;i++){
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int startInorder,
                          int endInorder, int startPostOrder, int endPostOrder) {
        if(startInorder > endInorder || startPostOrder > endPostOrder){
            return null;
        }

        TreeNode root = new TreeNode();
        root.val = postorder[endPostOrder];
        int inorderIndex = map.get(postorder[endPostOrder]);
        int leftSize = inorderIndex - startInorder;

        root.left = build(inorder, postorder,startInorder, startInorder+leftSize - 1, startPostOrder, startPostOrder + leftSize - 1 );
        root.right = build(inorder, postorder, inorderIndex + 1, endInorder, startPostOrder + leftSize, endPostOrder - 1);
        return root;
    }
}
