package ProgrammerCarl.PopulatingNextRightPointersInEachNodeII117;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public Node connect(Node root) {
        Deque<Node> deque = new LinkedList<>();
        if(root==null){
            return root;
        }

        deque.offerLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size > 0){
                Node tmp = deque.pollFirst();
                if(size != 1){
                    tmp.next = deque.peekFirst();
                }

                if(tmp.left != null){
                    deque.offerLast(tmp.left);
                }
                if(tmp.right != null){
                    deque.offerLast(tmp.right);
                }
                size--;
            }
        }
        return root;

    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}