package Top100Question.PalindromeLinkedList234;

import 每日一题.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // find the center of the list, then reverse the second half of the list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondStart = slow.next;
        // reverse
        ListNode pre = null;
        ListNode cur = secondStart;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // second half head in pre
        ListNode index1 = head;
        ListNode index2 = pre;

        while(index2!=null){
            if(index2.val!=index1.val){
                return false;
            }
            index2 = index2.next;
            index1 = index1.next;
        }
        return true;
    }
}
