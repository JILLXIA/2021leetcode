package labuladong.SerializeAndDeserializeBinaryTree297;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	StringBuilder sb = new StringBuilder();
	String sparater = ";";
	String emptyNode = "#";
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerLast(root);
		while(!deque.isEmpty()){
			TreeNode tmp = deque.pollFirst();
			if(tmp==null){
				sb.append(emptyNode);
				sb.append(sparater);
				continue;
			}
			sb.append(tmp.val);
			sb.append(sparater);
			deque.offerLast(tmp.left);
			deque.offerLast(tmp.right);
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] sData = data.split(sparater);
		Deque<String> nodeList = new LinkedList<>();
		for(String s:sData){
			nodeList.offerLast(s);
		}
		String rootValue = nodeList.pollFirst();
		if(nodeList.isEmpty() || rootValue.equals(emptyNode)){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(rootValue));
		Deque<TreeNode> treeList = new LinkedList<>();
		treeList.offerLast(root);
		while(!nodeList.isEmpty()){
			TreeNode curr = treeList.pollFirst();
			String leftValue = nodeList.pollFirst();
			if(leftValue.equals(emptyNode)){
				curr.left = null;
			}else{
				curr.left = new TreeNode(Integer.parseInt(leftValue));
				treeList.offerLast(curr.left);
			}
			String rightValue = nodeList.pollFirst();
			if(rightValue.equals(emptyNode)){
				curr.right = null;
			}else{
				curr.right = new TreeNode(Integer.parseInt(rightValue));
				treeList.offerLast(curr.right);
			}
		}
		return root;
	}
}
