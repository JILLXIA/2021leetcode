package 树.填充每个节点的下一个右侧节点指针II117;

/**
 * 实际上是一道链表和树结合起来的问题
 *
 * 遍历当前层的节点的时候，就把狭义
 */
public class Solution1 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node cur = root;
        while(cur!=null){
            Node dummynode = new Node(0);
            Node pre = dummynode;
            while(cur!=null){
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummynode.next;
        }
        return root;
    }
}
