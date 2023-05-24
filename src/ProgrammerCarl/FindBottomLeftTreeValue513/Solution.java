package ProgrammerCarl.FindBottomLeftTreeValue513;

import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given the root of a binary tree,
 * return the leftmost value in the last row of the tree.
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();

        int result = 0;
        if(root == null) {
            return result;
        }
        deque.offerLast(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            int count = size;
            while(count > 0){
                TreeNode tmp = deque.pollFirst();
                if(count == size){
                    result = tmp.val;
                }

                if(tmp.left != null){
                    deque.offerLast(tmp.left);
                }

                if(tmp.right != null){
                    deque.offerLast(tmp.right);
                }
                count--;
            }
        }
        return result;
    }
}
