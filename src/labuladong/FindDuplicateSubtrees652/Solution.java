package labuladong.FindDuplicateSubtrees652;

import 每日一题.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node values.
 */
public class Solution {
	// 难点在于如何判断当前的二叉树和某一个相等，得想到二叉树序列化的方法
	HashMap<String,Integer> map = new HashMap<>();
	List<TreeNode> result = new ArrayList<>();
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		realFindDuplicate(root);
		return result;
	}

	public String realFindDuplicate(TreeNode root){
		if(root==null){
			return "#";
		}
		String left = realFindDuplicate(root.left);
		String right = realFindDuplicate(root.right);
		StringBuilder sb = new StringBuilder();
		sb.append(left);
		sb.append(",");
		sb.append(right);
		sb.append(",");
		sb.append(root.val);
		String answer = sb.toString();
		if(map.containsKey(answer)){
			map.put(answer,map.get(answer)+1);
			if(map.get(answer)==2){
				result.add(root);
			}
		}else{
			map.put(answer,1);
		}
		return sb.toString();
	}
}
