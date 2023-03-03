package ProgrammerCarl.BinaryTreepostorderTraversal145;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> deque= new LinkedList<>();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        // use cursor
        while(curr != null || !deque.isEmpty()){
            if(curr != null){
                result.add(0,curr.val);
                deque.offerLast(curr);
                curr = curr.right;
            } else {
                curr = deque.pollLast();

                curr = curr.left;
            }
        }
        return result;
    }
}
