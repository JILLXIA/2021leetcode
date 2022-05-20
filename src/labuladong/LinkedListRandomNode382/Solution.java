package labuladong.LinkedListRandomNode382;

import 每日一题.ListNode;

import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 *
 * Implement the Solution class:
 *
 * Solution(ListNode head) Initializes the object with the head of the
 * singly-linked list head.
 * int getRandom() Chooses a node randomly from the list and returns its value.
 * All the nodes of the list should be equally likely to be chosen.
 */
public class Solution {
	ListNode head;
	public Solution(ListNode head) {
		this.head = head;
	}

	public int getRandom() {
		int i = 1;
		Random rd = new Random();
		ListNode curr = head;
		int res = head.val;
		while(curr!=null){// uniformly distributed int value between 0 (inclusive) and the specified value (exclusive),
			// drawn from this random number generator's sequence.
			if(rd.nextInt(i)==0){
				res = curr.val;
			}
			i++;
			curr = curr.next;
		}
		return res;
	}
}
