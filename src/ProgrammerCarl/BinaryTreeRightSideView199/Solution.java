package ProgrammerCarl.BinaryTreeRightSideView199;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself
 * standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if(root == null){
            return result;
        }

        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            while(size > 0){
                TreeNode tmp = deque.pollFirst();
                if(size == 1){
                    result.add(tmp.val);
                }

                if(tmp.left != null){
                    deque.offerLast(tmp.left);
                }

                if(tmp.right != null){
                    deque.offerLast(tmp.right);
                }
                size--;
            }
        }
        return result;
    }
}
