package ProgrammerCarl.AverageOfLevelsInBinary637;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree,
 * return the average value of the nodes on each level
 * in the form of an array. Answers within 10-5 of the actual
 * answer will be accepted.
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if(root == null){
            return result;
        }

        deque.offerLast(root);

        while(!deque.isEmpty()){
            double sum = 0.0;
            int size = deque.size();
            int count = size;
            while(size > 0){
                TreeNode curr = deque.pollFirst();
                sum += curr.val;

                if(curr.left != null){
                    deque.offerLast(curr.left);
                }

                if(curr.right != null){
                    deque.offerLast(curr.right);
                }
                size--;
            }
            result.add(sum / count);
        }
        return result;
    }
}
