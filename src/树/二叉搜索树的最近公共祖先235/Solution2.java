package 树.二叉搜索树的最近公共祖先235;

import 树.TreeNode;

/**
 * (flson&&frson)∣∣((x=p∣∣x=q)&&(flson∣∣frson))
 */
public class Solution2 {
    TreeNode result = new TreeNode();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    public boolean dfs(TreeNode root,TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        boolean flson = dfs(root.left,p,q);//左子树是否含有pq
        boolean frson = dfs(root.right,p,q);//右子树是否含有pq
        if((flson&&frson) || ((root==p||root==q)&&(flson||frson))){
            result = root;
        }
        return flson||frson||(root.val==p.val)||(root.val==q.val);
    }
}
