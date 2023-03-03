package ProgrammerCarl.FindLargestValueInEachTreeRow515;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree,
 * return an array of the largest value in each row of the tree (0-indexed).
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if(root == null){
            return result;
        }

        deque.offerLast(root);

        while(!deque.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = deque.size();
            int count = size;
            while(size > 0){
                TreeNode curr = deque.pollFirst();
                max = Math.max(max, curr.val);

                if(curr.left != null){
                    deque.offerLast(curr.left);
                }

                if(curr.right != null){
                    deque.offerLast(curr.right);
                }
                size--;
            }
            result.add(max);
        }
        return result;
    }
}
