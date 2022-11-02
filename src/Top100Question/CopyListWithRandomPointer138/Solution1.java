package Top100Question.CopyListWithRandomPointer138;

public class Solution1 {
    // space complexity O(1)
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node current = head;
        while(current!=null){
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = current.next.next;
        }

        // assign the random node
        current = head;
        while(current!=null){
            Node random = current.random;
            // random 可能为null
            current.next.random = random==null ? null : random.next;
            current = current.next.next;
        }

        // splite the original list and the new list
        Node oldHead = head;
        Node newHead = head.next;
        Node result = newHead;
        while(oldHead!=null){
            oldHead.next = newHead.next;
            newHead.next = newHead.next==null ? null : newHead.next.next;
            oldHead = oldHead.next;
            newHead = newHead.next;
        }
        return result;
    }
}
