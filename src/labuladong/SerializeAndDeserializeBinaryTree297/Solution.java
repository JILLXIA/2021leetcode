package labuladong.SerializeAndDeserializeBinaryTree297;

import 每日一题.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */
public class Solution {
	StringBuilder sb = new StringBuilder();
	char emptyNode = '#';
	char sparater = ',';
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
		sb.append(root.val);
		sb.append(sparater);
		realSerialize(root.left);
		realSerialize(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] sArr = data.split(",");
		for(String s:sArr){
			deque.offerLast(s);
		}
		return realDeserialize();
	}

	public TreeNode realDeserialize(){
		if(deque.isEmpty()){
			return null;
		}
		String tmp = deque.pollFirst();
		if(tmp.equals("#")){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(tmp));
		root.left = realDeserialize();
		root.right = realDeserialize();
		return root;
	}

	public static void main(String[] args){
		String[] s = ",".split(",");
		System.out.println(s.length);
	}
}
