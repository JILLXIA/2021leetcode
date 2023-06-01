package ProgrammerCarl.ConvertSortedArrayToBinarySearchTree108;

import 树.TreeNode;

/**
 * Given an integer array nums where the
 * elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
