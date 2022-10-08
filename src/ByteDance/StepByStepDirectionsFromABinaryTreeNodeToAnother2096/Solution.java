package ByteDance.StepByStepDirectionsFromABinaryTreeNodeToAnother2096;

import 树.TreeNode;

/**
 * You are given the root of a binary tree with n nodes.
 * Each node is uniquely assigned a value from 1 to n.
 * You are also given an integer startValue representing the value
 * of the start node s, and a different integer destValue
 * representing the value of the destination node t.
 *
 * Find the shortest path starting from node s and ending at node t.
 * Generate step-by-step directions of such path as a string consisting
 * of only the uppercase letters 'L', 'R', and 'U'.
 * Each letter indicates a specific direction:
 *
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * Return the step-by-step directions of the shortest path from node s to node t.
 */
public class Solution {
    boolean isFind = false;
    String result = "";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String s1 = "";
        String s2 = "";
        findNode(root, startValue,new StringBuilder());
        s1 = result;
        isFind = false;
        result = "";
        findNode(root, destValue,new StringBuilder());
        s2 = result;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        for(int i = 0;i<s1.length();i++){
            if(i >= s2.length()){
                break;
            }
            if(s1.charAt(i)==s2.charAt(i)){
                index1++;
                index2++;
            } else {
                break;
            }
        }

        while(index1 < s1.length() || index2 < s2.length()){
            if(index1 < s1.length() && index2 < s2.length()){
                // 注意是找前缀
                sb1.append("U");
                sb2.append(s2.charAt(index2));
                index1++;
                index2++;
            } else if(index1 < s1.length()){
                sb1.append("U");
                index1++;
            } else if(index2 < s2.length()){
                sb2.append(s2.charAt(index2));
                index2++;
            }
        }
        return sb1.append(sb2).toString();
    }

    public void findNode(TreeNode root, int val, StringBuilder sb){
        if(root==null){
            return;
        }
        if(val==root.val){
            result = sb.toString();
            isFind = true;
            return;
        }
        if(isFind){
            return;
        }
        sb.append("L");
        findNode(root.left,val,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append("R");
        findNode(root.right,val,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
