package 树.不同的二叉搜索树II95;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，
 * 生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 */

/**
 * 遇到树有关的问题，非常容易想到递归
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0){
            return null;
        }
        return generate(1,n);
    }

    public List<TreeNode> generate(int start,int end){
        List<TreeNode> result = new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }

        for(int i = start;i<=end;i++){
            List<TreeNode> leftTree = generate(start,i-1);
            List<TreeNode> rightTree = generate(i+1,end);


            for(int a = 0;a<leftTree.size();a++){
                for(int b = 0;b<rightTree.size();b++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree.get(a);
                    root.right = rightTree.get(b);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
