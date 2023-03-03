package ProgrammerCarl.BinaryTreeLevelOrderTraversalII107;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree,
 * return the bottom-up level order traversal of its nodes' values.
 * (i.e., from left to right, level by level from leaf to root).
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if(root == null){
            return result;
        }

        deque.offerLast(root);

        while(!deque.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = deque.size();
            while(size > 0){
                TreeNode curr = deque.pollFirst();
                tmp.add(curr.val);

                if(curr.left != null){
                    deque.offerLast(curr.left);
                }

                if(curr.right != null){
                    deque.offerLast(curr.right);
                }
                size--;
            }
            result.add(0, tmp);
        }
        return result;
    }
}
