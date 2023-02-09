package ProgrammerCarl.SwappingNodesInALinkedList1721;

import 每日一题.ListNode;

/**
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node
 * from the beginning and the kth node from the end (the list is 1-indexed).
 */
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // find the start and end node
        // then swap the value of the two node

        ListNode fast = head;
        ListNode slow = head;

        ListNode first = null;
        for(int i = 1;i<k;i++){
            fast  = fast.next;
        }
        first = fast;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        int tmp = first.val;
        first.val = slow.val;
        slow.val = tmp;
        return head;
    }
}
