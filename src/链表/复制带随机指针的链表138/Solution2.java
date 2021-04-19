package 链表.复制带随机指针的链表138;

/**
 * 通过扭曲原来的链表，并将每个拷贝节点都放在原来对应节点的旁边。
 * 这种旧节点和新节点交错的方法让我们可以在不需要额外空间的情况下解决这个问题。
 */
public class Solution2 {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node ptr = head;
        while(ptr!=null){
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        //先复制random
        ptr = head;
        while(ptr!=null){
            ptr.next.random = ptr.random!=null?ptr.random.next:null;
            ptr = ptr.next.next;
        }
        ptr = head;
        Node newHead = head.next;
        Node ptr2 = head.next;

        while(ptr!=null){
            ptr.next = ptr.next.next;
            ptr2.next = ptr2.next!=null?ptr2.next.next:null;
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        return newHead;
    }
}
