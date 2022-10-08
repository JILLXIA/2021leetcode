package ByteDance.ReverseNodesInkGroup25;

import 每日一题.ListNode;

/**
 * Given the head of a linked list,
 * reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal
 * to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes,
 * only nodes themselves may be changed.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) {
            return null;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode preP1 = dummy;
        ListNode nextP2 = null;

        int count = k-1; //pointer2只能往前走k-1步
        while(pointer2 != null){
            // pointer 2的最终位置要停在最后一个节点，而不是null节点
            while(pointer2.next!=null && count > 0){
                pointer2 = pointer2.next;
                count--;
            }
            if(count > 0){
                // System.out.println("enter");
                return dummy.next;
            }
            nextP2 = pointer2.next;
            ListNode pre = preP1;
            ListNode cur = pointer1;
            ListNode next;
            while(cur!=nextP2){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            preP1.next = pre;
            pointer1.next = nextP2;
            preP1 =  pointer1;
            pointer1 = nextP2;
            pointer2 = nextP2;
            count = k-1;
        }
        return dummy.next;
    }
}
