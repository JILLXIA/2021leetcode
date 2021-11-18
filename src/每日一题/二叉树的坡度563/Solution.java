package 每日一题.二叉树的坡度563;

import java.util.HashMap;

/**
 * 给定一个二叉树，计算 整个树 的坡度 。
 *
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
 * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 *
 * 整个树 的坡度就是其所有节点的坡度之和。
 */
public class Solution {
    HashMap<TreeNode,Integer> map = new HashMap<>();
    public int findTilt(TreeNode root) {
        if(root == null) {
            map.put(root,0);
            return 0;
        } else {
            int left = findTilt(root.left);
            int right = findTilt(root.right);
            map.put(root,root.val + map.get(root.left) + map.get(root.right));
            return left + right + Math.abs(map.get(root.left) - map.get(root.right));
        }
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}