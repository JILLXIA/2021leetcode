package 树.二叉搜索树中第K小的元素230;

import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）
 * 并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode tmp = new TreeNode(0);
        while(root!=null || !deque.isEmpty()){
            while(root!=null){
                deque.offerLast(root);
                root = root.left;
            }

            tmp = deque.pollLast();
            k--;
            root = tmp.right;
            if(k==0){
                return tmp.val;
            }
        }
        return 0;
    }
}
