package labuladong.ConstructBinaryTreeFromInorderAndPostorderTraversal106;

import 树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    Map<Integer, Integer> map = new HashMap<>();
    // use HashMap to find the index quickly

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i< inorder.length;i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder,
                          int startInorder, int endInorder,
                          int startPostorder, int endPostorder) {
        if(startInorder > endInorder || startPostorder > endPostorder) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[endPostorder]);
        int rootIndexInorder = -1;

        for(int i = startInorder; i<= endInorder;i++) {
            if(inorder[i] == postorder[endInorder]){
                rootIndexInorder = i;
                break;
            }
        }
        // int rootIndexInorder = map.get(postorder[endPostorder]);
        root.left = build(inorder, postorder, startInorder, rootIndexInorder - 1, startPostorder, startPostorder + (rootIndexInorder - startInorder - 1));
        // root.right = build(inorder, postorder, rootIndexInorder + 1, endInorder,startPostorder + rootIndexInorder - startInorder ,endPostorder - 1);
        root.right = build(inorder, postorder, rootIndexInorder + 1, endInorder,endPostorder - (endInorder - rootIndexInorder) ,endPostorder - 1);
        return root;
    }
}
