package 树.二叉树的中序遍历94;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 试试非递归
 */
public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        //记住了哈，树的遍历是两层循环
        while(root!=null||!deque.isEmpty()){
            while(root!=null){
                deque.offerLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
