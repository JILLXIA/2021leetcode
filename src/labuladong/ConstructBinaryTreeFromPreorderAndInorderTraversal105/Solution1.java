package labuladong.ConstructBinaryTreeFromPreorderAndInorderTraversal105;

import 树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return build(preorder,inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int startPreOrder, int endPreOrder, int startInorder, int endInorder) {
        if(startPreOrder > endPreOrder || startInorder > endInorder) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPreOrder]);

        int rootInorder = map.get(preorder[startPreOrder]);
        int leftSize = rootInorder - startInorder;

        root.left = build(preorder, inorder, startPreOrder + 1, startPreOrder+leftSize, startInorder, startInorder + leftSize - 1  );
        root.right = build(preorder, inorder, startPreOrder+leftSize + 1, endPreOrder, rootInorder + 1, endInorder);
        return root;
    }
}
