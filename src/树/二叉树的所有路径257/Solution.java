package 树.二叉树的所有路径257;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 用Stringbuilder比用String快一点，注意参数里用string
 * 如果参数是Stringbuilder需要回溯remove掉
 */
public class Solution {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return result;
        }
        dfs(root,"");
        return result;
    }
    public void dfs(TreeNode root,String s){
        StringBuilder path = new StringBuilder(s);
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            path.append(root.val);
            result.add(path.toString());
            return;
        }
        path.append(root.val+"->");
        if(root.left!=null){
            dfs(root.left,path.toString());//path的作用域一定要在函数里面，
            // 传s+"->"不会有问题，是因为当前还输作用域的s没有变

        }
        if(root.right!=null) {
            dfs(root.right, path.toString());
        }
    }
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        Solution s = new Solution();
        s.binaryTreePaths(n1);
    }
}
