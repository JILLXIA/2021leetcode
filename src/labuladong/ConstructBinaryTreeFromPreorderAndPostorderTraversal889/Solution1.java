package labuladong.ConstructBinaryTreeFromPreorderAndPostorderTraversal889;

import 树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // the answer is not unique
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] postorder, int startPreorder, int endPreorder, int startPostorder, int endPostorder) {
        if(startPreorder > endPreorder || startPostorder > endPostorder|| startPreorder >= preorder.length || startPostorder >= postorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPreorder]);
        if(startPreorder < endPreorder) {
            // 如果相等的话就不用追溯后面一个了
            int leftIndex = map.get(preorder[startPreorder + 1]);
            int leftSize = leftIndex - startPostorder + 1; // 3
            root.left = build(preorder, postorder, startPreorder + 1, startPreorder + leftSize, startPostorder, startPostorder + leftSize - 1);
            root.right = build(preorder, postorder, startPreorder + leftSize + 1, endPreorder, startPostorder + leftSize, endPostorder - 1);
        }
        return root;
    }
}
