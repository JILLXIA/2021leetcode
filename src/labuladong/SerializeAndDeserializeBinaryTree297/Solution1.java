package labuladong.SerializeAndDeserializeBinaryTree297;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
	StringBuilder sb = new StringBuilder();
	String sparater = ";";
	String emptyNode = "#";

	Deque<String> deque = new LinkedList<>();
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		realSerialize(root);
		return sb.toString();
	}

	public void realSerialize(TreeNode root){
		if(root==null){
			sb.append(emptyNode);
			sb.append(sparater);
			return;
		}
		realSerialize(root.left);
		realSerialize(root.right);
		sb.append(root.val);
		sb.append(sparater);
	}
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] sArr = data.split(";");
		for(String s:sArr){
			deque.offerLast(s);
		}
		return realDeserialize();
	}
	public TreeNode realDeserialize(){
		if(deque.isEmpty()){
			return null;
		}
		String tmp = deque.pollLast();
		if(tmp.equals(emptyNode)){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(tmp));
		root.right = realDeserialize();
		root.left = realDeserialize();
		return root;
	}
}
