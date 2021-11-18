package 每日一题.二叉树的坡度563;

public class Solution1 {
    int ans = 0;
    public int findTilt(TreeNode root) {
        // 脑子咋不会转弯呢？？
        if(root == null){
            return 0;
        } else {
            dfs(root);
            return ans;
        }
    }

    public int dfs (TreeNode root) {
        if(root == null){
            return 0;
        } else {
            int left = dfs(root.left);
            int right = dfs(root.right);
            ans += Math.abs(left-right);
            return left + right + root.val;
        }
    }
}
