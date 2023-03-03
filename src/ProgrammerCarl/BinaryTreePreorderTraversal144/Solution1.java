package ProgrammerCarl.BinaryTreePreorderTraversal144;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;
        if(curr==null){
            return result;
        }

        while(curr != null || !deque.isEmpty()){
            if(curr != null){
                result.add(curr.val);
                deque.offerLast(curr);
                curr = curr.left;
            } else {
                curr = deque.pollLast();
                curr = curr.right;
            }
        }
        return result;
    }
}
