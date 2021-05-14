package 树.二叉树的右视图199;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，
 * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //层序遍历，取每一层的最后一个
        Deque<TreeNode> deque = new LinkedList<>();
        if(root==null){
            return new ArrayList<>();
        }
        deque.offerLast(root);
        List<Integer> result = new ArrayList<>();
        int size = deque.size();

        int count = 0;

        while(!deque.isEmpty()){
            count++;

            TreeNode tmp = deque.pollFirst();
            if(tmp.left!=null){
                deque.offerLast(tmp.left);
            }
            if(tmp.right!=null){
                deque.offerLast(tmp.right);
            }
            if(count==size){
                result.add(tmp.val);
                size = deque.size();
                count  = 0;
            }
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;

        Solution s = new Solution();
        s.rightSideView(n1);
    }
}
