package 树.二叉树展开为链表114;

import 树.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Solution {
    /**
     * 如果左子树为null,直接跳到下一个节点
     * 当左子树不为null，先找到左子树最右边的节点，将右子树接到左子树最右边的节点
     * 将接完的左子树变成右子树，左子树变成空
     * 更新当前遍历到的节点
     * @param root
     */
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left==null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while(pre.right!=null){
                    pre = pre.right;//找到左子树最右边的节点
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
