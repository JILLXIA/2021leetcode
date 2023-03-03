package ProgrammerCarl.BinaryTreeInorderTraversal94;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> deque= new LinkedList<>();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        // use cursor
        while(curr != null || !deque.isEmpty()){
            if(curr != null){
                deque.offerLast(curr);
                curr = curr.left;
            } else {
                curr = deque.pollLast();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
}
