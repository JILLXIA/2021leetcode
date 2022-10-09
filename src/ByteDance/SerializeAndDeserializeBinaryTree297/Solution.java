package ByteDance.SerializeAndDeserializeBinaryTree297;

import 树.TreeNode;

/**
 * Serialization is the process of converting a data structure or
 * object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later
 * in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string
 * and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode
 * serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 */
public class Solution {
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }
    public void dfsSerialize(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append('#');
            sb.append(';');
            return;
        }
        sb.append(root.val);
        sb.append(';');
        dfsSerialize(root.left,sb);
        dfsSerialize(root.right,sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(";");
        return dfsDeserialize(s);
    }


    public TreeNode dfsDeserialize(String[] s){
        if(index >= s.length){
            return null;
        }

        if(s[index].equals("#")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[index]));
        index++;
        root.left = dfsDeserialize(s);
        root.right = dfsDeserialize(s);
        return root;
    }
}
