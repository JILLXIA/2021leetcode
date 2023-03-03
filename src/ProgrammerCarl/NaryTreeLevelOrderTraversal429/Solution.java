package ProgrammerCarl.NaryTreeLevelOrderTraversal429;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();

        if(root == null){
            return result;
        }

        deque.offerLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> rowList = new ArrayList<>();

            while(size > 0){
                Node tmp = deque.pollFirst();
                rowList.add(tmp.val);
                for(Node child: tmp.children){
                    if(child != null) {
                        deque.offerLast(child);
                    }
                }
                size--;
            }
            result.add(rowList);
        }
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}