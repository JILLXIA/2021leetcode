package Top100Question.CopyListWithRandomPointer138;

import java.util.HashMap;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */
public class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap();// old Node To new Node
        if(head==null){
            return null;
        }
        Node newHead = new Node(head.val);
        map.put(head,newHead);
        Node current = head;
        while(current != null){
            Node nextOldNode = current.next;
            Node nextRandomNode = current.random;

            if(!map.containsKey(nextOldNode)){
                if(nextOldNode==null){
                    map.put(nextOldNode, null);
                } else {
                    map.put(nextOldNode, new Node(nextOldNode.val));
                }
            }
            if(!map.containsKey(nextRandomNode)){
                if(nextRandomNode==null){
                    map.put(nextRandomNode, null);
                } else {
                    map.put(nextRandomNode, new Node(nextRandomNode.val));
                }
            }

            map.get(current).next = map.get(nextOldNode);
            map.get(current).random = map.get(nextRandomNode);
            current = nextOldNode;
        }
        return map.get(head);

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}