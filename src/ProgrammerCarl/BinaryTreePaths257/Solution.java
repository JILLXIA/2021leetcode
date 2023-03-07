package ProgrammerCarl.BinaryTreePaths257;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree,
 * return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 */
public class Solution {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        backTrace(root, path);
        return result;
    }

    public void backTrace(TreeNode root, List<Integer> path){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            path.add(root.val);
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < path.size();i++){
                sb.append(path.get(i));
                if(i != path.size() - 1){
                    sb.append("->");
                }
            }
            result.add(sb.toString());
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        backTrace(root.left, path);
        backTrace(root.right,path);
        path.remove(path.size() - 1);
    }
}
