package 树.二叉树展开为链表114;

import 树.TreeNode;

/**
 * 我们依次遍历 6 5 4 3 2 1，
 * 然后每遍历一个节点就将当前节点的右指针更新为上一个节点。
 *
 * 遍历到 5，把 5 的右指针指向 6。6 <- 5 4 3 2 1。
 *
 * 遍历到 4，把 4 的右指针指向 5。6 <- 5 <- 4 3 2 1。
 */
public class Solution1 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
