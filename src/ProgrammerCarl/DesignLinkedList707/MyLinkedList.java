package ProgrammerCarl.DesignLinkedList707;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 */
public class MyLinkedList {
    // double linked list
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    public MyLinkedList() {
        head = new DoubleLinkedNode(-1);
        tail = new DoubleLinkedNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        // find the indexth node, O(n)
        DoubleLinkedNode curr = head;
        for(int i = 0;i <= index;i++){
            if(curr == null){
                return -1;
            }
            curr = curr.next;
        }
        return curr == null ? -1 : curr.val;
    }

    public void addAtHead(int val) {
        // add the node O(1)
        DoubleLinkedNode item = new DoubleLinkedNode(val);
        item.next = head.next;
        head.next.prev = item;
        head.next = item;
        item.prev = head;
    }

    public void addAtTail(int val) {
        // add the node to tail O(1)
        DoubleLinkedNode item = new DoubleLinkedNode(val);
        tail.prev.next = item;
        item.prev = tail.prev;
        tail.prev = item;
        item.next = tail;
    }

    public void addAtIndex(int index, int val) {
        DoubleLinkedNode item = new DoubleLinkedNode(val);
        DoubleLinkedNode curr = head;
        for(int i = 0;i <= index;i++){
            if(curr == null){
                return;
            }
            curr = curr.next;
        }
        if(curr == null){
            return;
        }
        curr.prev.next = item;
        item.prev = curr.prev;
        curr.prev = item;
        item.next = curr;
    }

    public void deleteAtIndex(int index) {
        DoubleLinkedNode curr = head;
        for(int i = 0;i <= index;i++){
            if(curr == null){
                return;
            }
            curr = curr.next;
        }
        if(curr == null || curr.val==-1){
            return;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
}

class DoubleLinkedNode {
    int val;
    DoubleLinkedNode prev;
    DoubleLinkedNode next;

    public DoubleLinkedNode(int val, DoubleLinkedNode prev, DoubleLinkedNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public DoubleLinkedNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public DoubleLinkedNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedNode prev) {
        this.prev = prev;
    }

    public DoubleLinkedNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode next) {
        this.next = next;
    }
}