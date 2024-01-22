package Grind75.MiddleOfTheLinkedList876;

import 每日一题.ListNode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class Solution1 {
    public ListNode middleNode(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
