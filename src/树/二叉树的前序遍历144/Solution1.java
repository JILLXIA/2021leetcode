package 树.二叉树的前序遍历144;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> arr = new LinkedList<>();
        if(root==null){
            return result;
        }
        while(!arr.isEmpty()||root!=null){
            while(root!=null){
                arr.add(root);
                result.add(root.val);
                root = root.left;
            }
            TreeNode tmp = arr.pollLast();
            root = tmp.right;
        }
        return result;
    }
}
