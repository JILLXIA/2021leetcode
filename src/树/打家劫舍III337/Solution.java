package 树.打家劫舍III337;

import 树.TreeNode;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，
 * 小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */

/**
 * 非常明显的动态规划问题，要寻找最佳子结构
 *
 * 这个方法会有重复的子结构被重复计算了，可以用HashMap保存起来，进行剪枝
 */
public class Solution {
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        int money = root.val;
        if(root.left!=null){
            money += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money,rob(root.left)+rob(root.right));
    }
}
