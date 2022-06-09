package labuladong.UniqueBinarySearchTreesII95;

import 每日一题.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n,
 * return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n.
 * Return the answer in any order.
 */
public class Solution {
	public List<TreeNode> generateTrees(int n) {
		return generate(1,n);
	}

	public List<TreeNode> generate(int low, int high){
		List<TreeNode> result = new ArrayList<>();
		if(low > high){
			result.add(null);
			return result;
		}
		for(int i = low; i<=high;i++){
			List<TreeNode> leftList = generate(low, i-1);
			List<TreeNode> rightList = generate(i+1, high);
			for(TreeNode left: leftList){
				for(TreeNode right: rightList){
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					result.add(root);
				}
			}
		}
		return result;
	}
}
