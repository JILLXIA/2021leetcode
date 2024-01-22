package Grind75.LinkedListCycleII142;

import 每日一题.ListNode;

/**
 * Given the head of a linked list,
 * return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node
 * in the list that can be reached again by continuously
 * following the next pointer.
 * Internally, pos is used to denote the index of the
 * node that tail's next pointer is connected to (0-indexed).
 * It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 1. has cycle
        // 2. find the meet node
        // 3. x-----c------z    2x+2c = x + (2c+z) * k

        if(head == null) {
            return null;
        }
        // start from the same starting point
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
