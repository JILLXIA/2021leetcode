package ProgrammerCarl.SwapNodesInPairs24;

import 每日一题.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 反转任意链表的任意长度部分
        // recursive
        // edge case
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode next = head.next;
        ListNode nextRecursive = next.next;
        next.next = head;
        head.next = swapPairs(nextRecursive);
        return next;
    }
}
