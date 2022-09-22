package Google.StepByStepDirectionsFromABinarytreeNodeToAnother2096;

import 树.TreeNode;

/**
 * You are given the root of a binary tree with n nodes.
 * Each node is uniquely assigned a value from 1 to n.
 * You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.
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
    boolean flag = false;
    String result = "";
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String startS = "";
        String destS = "";
        dfs(new StringBuilder(),startValue,root);
        startS = result;
        flag = false;
        result = "";
        dfs(new StringBuilder(),destValue,root);
        destS = result;
        int index = 0;
        // find prefix
        for(int i = 0;i<Math.min(startS.length(),destS.length());i++){
            if(startS.charAt(index)==destS.charAt(index)){
                index++;
            } else {
                break;
            }
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while(index < startS.length() || index < destS.length()){
            if(index >= startS.length()){
                s2.append(destS.charAt(index));
            } else if(index >= destS.length()){
                s1.append("U");
            } else {
                s1.append("U");
                s2.append(destS.charAt(index));
            }
            index++;
        }
        return s1.append(s2).toString();

    }
    public void dfs(StringBuilder sb, int target, TreeNode node){
        if(node==null){
            return;
        }
        if(node.val==target){
            flag = true;
            result = sb.toString();
            return;
        }
        if(flag){
            return;
        }

        sb.append("L");
        dfs(sb,target,node.left);
        sb.deleteCharAt(sb.length()-1);
        sb.append("R");
        dfs(sb,target,node.right);
        sb.deleteCharAt(sb.length()-1);
    }
}
