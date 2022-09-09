package Amazon.LRUCache146;

import java.util.HashMap;

public class LRUCache2 {
    HashMap<Integer, Node> map;
    DoubleLinkedList doubleLinkedList;
    int capacity;
    public LRUCache2(int capacity) {
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        // get的时候相当于删了重新插入
        put(key,map.get(key).value);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        Node nodeRefresh = new Node(key,value);
        if(!map.containsKey(key)){
            // 插入
            if(map.size() == capacity){
                int keyRemove = doubleLinkedList.removeNodeToHead();
                map.remove(keyRemove);
            }
            doubleLinkedList.addNodeToTail(nodeRefresh);
            map.put(key,nodeRefresh);
        } else {
            doubleLinkedList.removeNode(map.get(key));
            map.remove(key);
            doubleLinkedList.addNodeToTail(nodeRefresh);
            map.put(key,nodeRefresh);
        }
    }

    public static void main(String[] args) {
        LRUCache2 lru2 = new LRUCache2(2);
        lru2.put(1,0);
        lru2.put(2,2);
        lru2.get(1);
        lru2.put(3,3);
        lru2.get(2);
        lru2.put(4,4);
        lru2.get(1);
    }
}

class Node{
    int key;
    int value;
    Node right;
    Node left;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList{
    Node head; // dump Node
    Node tail; // dump Node
    public DoubleLinkedList(){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.right = tail;
        tail.left = head;
        head.left = null;
        tail.right = null;

    }
    public void addNodeToTail(Node node){
//        tail.left.right = node;
//        node.left = tail.left;
//        tail.left = node;
//        node.right = tail;
        node.right = tail;
        node.left = tail.left;
        tail.left.right = node;
        tail.left = node;
    }

    public int removeNodeToHead(){
        Node removeNode = head.right;
        removeNode.right.left = head;
        head.right = removeNode.right;
        return removeNode.key;
    }

    public void removeNode(Node node){
        Node pre = node.left;
        Node next = node.right;
        pre.right = next;
        next.left = pre;
    }
}