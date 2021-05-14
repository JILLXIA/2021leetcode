package 树.二叉树的右视图199;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 也可以使用dfs遍历，根节点-》右子树-〉左子树
 *
 * 每次比较当前深度
 */
public class Solution1 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return result;
        }
        dfs(root,1);
        return result;
    }
    public void dfs(TreeNode root, int depth){
        if(depth== result.size()+1){
            result.add(root.val);
        }
        if(root.left==null && root.right==null){
            return;
        }

        if(root.right!=null){
            depth++;
            dfs(root.right,depth);
            depth--;
        }
        if(root.left!=null){
            depth++;
            dfs(root.left,depth);
        }
    }
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;

        Solution1 s = new Solution1();
        s.rightSideView(n1);
    }
}
