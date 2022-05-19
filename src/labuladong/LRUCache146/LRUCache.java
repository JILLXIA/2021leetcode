package labuladong.LRUCache146;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {
	// DoubleLinkedList + HashMap
	int capacity;
	DoubleLinkedList doubleLinkedList;
	HashMap<Integer, Node> map;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		doubleLinkedList = new DoubleLinkedList(0);
		map = new HashMap<>();
	}

	public int get(int key) {
		if(!map.containsKey(key)){
			return -1;
		}
		// get的时候相当于删了重新插入
		put(key,map.get(key).value);
		return map.get(key).value;
	}

	//	1. 插入已有的 2. 插入之前没有的
	public void put(int key, int value) {
		Node nodeRefresh = new Node(key,value);
		if(map.containsKey(key)){
			Node tmp = map.get(key);
			doubleLinkedList.remove(tmp);
			doubleLinkedList.add(nodeRefresh);
			map.put(key,nodeRefresh);
		} else {
			if(doubleLinkedList.getSize()==this.capacity){
				Node lastestNode = doubleLinkedList.removeLastest();
				map.remove(lastestNode.key);
			}
			doubleLinkedList.add(nodeRefresh);
			map.put(key,nodeRefresh);
		}
	}
}

class DoubleLinkedList{
	Node head;
	Node tail;
	int size;
	public int getSize(){
		return this.size;
	}
	public DoubleLinkedList(int size){
		this.size = size;
		head = new Node();
		tail = new Node();
		// head -> tail
		// head <- tail
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	public void add(Node x){
		// add Node into the end of the list
		// y -> tail
		// y <- tail
		// y -> x -> tail
		// y <- x <- tail
		x.next = tail;
		x.prev = tail.prev;
		tail.prev.next = x;
		tail.prev = x;
		size++;
	}

	public void remove(Node x){
		// remove the specific node in the list
		// y -> x -> tail
		// y <- x <- tail
		// y -> tail
		// y <- tail
		x.prev.next = x.next;
		x.next.prev = x.prev;
		size--;
	}
	public Node removeLastest(){
		// why return node? 需要到hashMap里面找到对应的
		// remove the first node
		Node tmp = head.next;
		tmp.next.prev = head;
		head.next = tmp.next;
		size--;
		return tmp;
	}
}
class Node{
	int key;
	int value;
	// double linked list
	Node next;
	Node prev;
	public Node(int key, int value){
		this.key = key;
		this.value = value;
	}
	public Node(){

	}
}