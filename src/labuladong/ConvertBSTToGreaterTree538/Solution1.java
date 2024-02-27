package labuladong.ConvertBSTToGreaterTree538;

import 树.TreeNode;

public class Solution1 {
    // BST 一定想到中序遍历
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
