package 树.路径总和II113;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return result;
        }
        tmp.add(root.val);
        calPath(root,targetSum,root.val);
        return result;
    }

    public void calPath(TreeNode root, int targetSum,
                        int curSum){
        if(targetSum==curSum && root.left==null && root.right==null){
            result.add(new ArrayList<>(tmp));
            return;
        }

        if(root.left==null && root.right==null){
            return;
        }

        if(root.left!=null){
            tmp.add(root.left.val);
            calPath(root.left,targetSum,
                    curSum+root.left.val);
            tmp.remove(tmp.size()-1);
        }

        if(root.right!=null){
            tmp.add(root.right.val);
            calPath(root.right,targetSum,
                    curSum+root.right.val);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n6.left = n9;
        n6.right = n10;
        Solution s = new Solution();
        System.out.println(s.pathSum(n1,22));
    }
}
