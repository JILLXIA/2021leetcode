package 树.填充每个节点的下一个右侧节点指针II117;

/**
 * 和116不一样，这个不是完全二叉树
 *
 * 下面这个解法解不出来。
 */
public class Solution {
    /**
     * 发现是有问题的，遍历到7的时候9-》1这个还没有建立关系
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return root;
        }

        if(root.right==null){//只用更新root.left.next的值
            Node tmp = root;
            while(tmp.next!=null &&
                    tmp.next.left==null &&
                    tmp.next.right==null){
                tmp = tmp.next;
            }
            if(tmp.next==null){
                root.left.next = null;
            }else{
                root.left.next = tmp.next.left==null?tmp.next.right:tmp.next.left;
            }
        }else{
            if(root.left!=null) {
                root.left.next = root.right;
            }
            Node tmp = root;
            while(tmp.next!=null &&
                    tmp.next.left==null &&
                    tmp.next.right==null){
                tmp = tmp.next;
            }
            if(tmp.next==null){
                root.right.next = null;
            }else{
                root.right.next = tmp.next.left==null?tmp.next.right:tmp.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        Node n1 = new Node(2);
        Node n2 = new Node(1);
        Node n3 = new Node(3);
        Node n4 = new Node(0);
        Node n5 = new Node(7);
        Node n6 = new Node(9);
        Node n7 = new Node(1);
        Node n8 = new Node(2);
        Node n9 = new Node(1);
        Node n10 = new Node(0);
        Node n11 = new Node(8);
        Node n12 = new Node(8);
        Node n13 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.left = n9;
        n5.right = n10;
        n7.left = n11;
        n7.right = n12;
        n9.left = n13;
        s.connect(n1);
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