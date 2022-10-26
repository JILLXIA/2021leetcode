package Top100Question.AddTwoNUmbers2;

import 每日一题.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        while(pointer1!=null || pointer2!=null){
            if(pointer1!=null && pointer2!=null){
                int value = (pointer1.val + pointer2.val + carry) % 10;
                carry = (pointer1.val + pointer2.val + carry) / 10;
                cur.next = new ListNode(value);
                cur = cur.next;
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            } else if(pointer1!=null){
                int value = (pointer1.val + carry) % 10;
                carry = (pointer1.val + carry) / 10;
                cur.next = new ListNode(value);
                cur = cur.next;
                pointer1 = pointer1.next;
            } else {
                int value = (pointer2.val + carry) % 10;
                carry = (pointer2.val + carry) / 10;
                cur.next = new ListNode(value);
                cur = cur.next;
                pointer2 = pointer2.next;
            }
        }
        // 注意carry位可能不为0
        if(carry==1){
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
