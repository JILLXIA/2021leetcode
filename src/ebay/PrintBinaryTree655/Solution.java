package ebay.PrintBinaryTree655;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        // height
        // BFS (parent, col, row)
        int height = height(root)-1;
        int n = (int)Math.pow(2, height+1) - 1;
        int[] line = new int[n];
        System.out.println(n);
        Deque<Triple> deque = new LinkedList();
        deque.offerLast(new Triple(root, 0, (n-1)/2));

        List<List<String>> result = new ArrayList();
        int curRow = 0;

        while(!deque.isEmpty()){
            int size = deque.size();
            line = new int[n];
            while(size > 0){
                Triple tmp = deque.pollFirst();
                line[tmp.col] = tmp.node.val;

                if(tmp.node.left!=null){
                    deque.offerLast(new Triple(tmp.node.left, curRow+1, tmp.col - (int)Math.pow(2, height - tmp.row - 1)));
                }

                if(tmp.node.right!=null){
                    deque.offerLast(new Triple(tmp.node.right, curRow+1, tmp.col + (int)Math.pow(2, height - tmp.row - 1)));
                }
                size--;
            }

            List<String> tmplist = new ArrayList();
            for(int i = 0;i<line.length;i++){
                if(line[i]==0){
                    tmplist.add("");
                } else {
                    tmplist.add(String.valueOf(line[i]));
                }
            }
            result.add(tmplist);
            curRow++;
        }
        return result;

    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        return Math.max(height(root.left), height(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        Solution s = new Solution();
        s.printTree(root);
    }
}

class Triple{
    TreeNode node;
    int row;
    int col;
    public Triple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}