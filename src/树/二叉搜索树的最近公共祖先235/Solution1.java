package 树.二叉搜索树的最近公共祖先235;

import 树.TreeNode;

/**
 * 傻了 没看到是二叉搜索树，可以利用二叉搜索树的性质啊
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        while(true){
            if((p.val<=root.val && q.val>=root.val) ||
                    (q.val<=root.val && p.val>=root.val)){
                return root;
            }else if(p.val<root.val && q.val<root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
    }
}
