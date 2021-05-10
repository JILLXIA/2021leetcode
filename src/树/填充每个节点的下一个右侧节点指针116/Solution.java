package 树.填充每个节点的下一个右侧节点指针116;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 填充它的每个 next 指针，
 * 让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 */
public class Solution {
    public Node connect(Node root) {
        // 想到层序遍历
        if(root==null){
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offerLast(root);
        int count = 1;
        int criteria = 1;
        int n = 1;
        while(!queue.isEmpty()){
            Node tmp = queue.pollFirst();
            if(count==criteria){
                tmp.next = null;
                criteria = criteria + (int)Math.pow(2,n);
                n++;
            }else{
                tmp.next = queue.peekFirst();
            }
            if(tmp.left!=null && tmp.right!=null){
                queue.offerLast(tmp.left);
                queue.offerLast(tmp.right);
            }
            count++;
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