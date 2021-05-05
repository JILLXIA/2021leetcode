package 树.将有序数组转换为二叉搜索树108;

import 树.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，
 * 请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足
 * 「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */

/**
 * 每次都取
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length==0){
            return null;
        }
        int n = nums.length-1;
        TreeNode root = buildTree(0,n,nums);;

        return root;
    }
    public TreeNode buildTree(int start,int end,int[] nums){
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(start,mid-1,nums);
        root.right = buildTree(mid+1,end,nums);
        return root;
    }
}
