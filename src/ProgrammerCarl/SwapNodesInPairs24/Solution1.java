package ProgrammerCarl.SwapNodesInPairs24;

import 每日一题.ListNode;

public class Solution1 {
    // iterator
    public ListNode swapPairs(ListNode head) {
        // curr 记录前面的dummy node
        // 交换curr.next 和 curr.next.next

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while(curr.next != null && curr.next.next != null){
            ListNode start = curr.next.next;
            ListNode next = start.next;
            ListNode end = curr.next;
            curr.next = start;
            start.next = end;
            end.next = next;
            curr = end;
        }
        return dummy.next;
    }
}
